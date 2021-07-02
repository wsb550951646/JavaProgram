package com.Cache.CacheManager;

import com.sun.deploy.cache.CacheEntry;
import org.junit.experimental.theories.DataPoints;

import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/259:31
 */
public class CacheManager {

    //单例模式
    private CacheManager(){}

    //是否开启清除失效缓存
    private volatile Boolean clearExpireCacheEnable = true;

    //缓存失效时间
    private long cacheTimeout = 12 * 60 * 60 * 1000L;

    //缓存记录
    private static LinkedList<Object> cacheUseRecord = new LinkedList<>();

    //可缓存的最大数量
    private static Integer MAX_CACHE_SIZE = 80;

    //读写锁
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static Lock writeLock = reentrantReadWriteLock.writeLock();
    private static Lock readLock = reentrantReadWriteLock.readLock();

    //Map 使用concurrentHashMap的Map
    private final static Map<Object, CacheEntry> cacheEntryMap = new ConcurrentHashMap<>();

    public void init(){
        initClearCache();
    }

    //自定义缓存失效时间
    public void init(Long cacheTimeout){

        this.cacheTimeout = cacheTimeout;
        initClearCache();

    }

    //初始化清除失效数据
    private void initClearCache(){
        //启动失效清理机制
        if(clearExpireCacheEnable){
            new ClearCacheTask().start();
        }

    }

    //单例模式
    private static CacheManager getCacheMangerInstance(){
        return CacheManagerFactory.CACHE_MANAGER;
    }

    //工厂类构造
    private static class CacheManagerFactory{
        private static final CacheManager CACHE_MANAGER = new CacheManager();
    }

    public void put(Object object, Object value) throws Exception {

        //判断缓存是否够用,LRU删除超出
        if(cacheEntryMap.size() > MAX_CACHE_SIZE)
            deleteLRU();
        //再判断抛异常
        if(cacheEntryMap.size() > MAX_CACHE_SIZE)
            throw new Exception("超过最大缓冲限制");

        //上锁添加数据
        CacheEntry cacheEntry = new CacheEntry(value);

        try {
        writeLock.lock();
        cacheEntryMap.put(object, cacheEntry);
            System.out.println("add key:"+object+"val:"+cacheEntry.getValue());
        if(cacheUseRecord.contains(object)){
            cacheUseRecord.remove(object);
        }
            cacheUseRecord.add(0, object);
        }finally {
            writeLock.unlock();
        }

    }

    private void deleteLRU(){

        Object cacheKey = null;

        try {
            writeLock.lock();
            cacheKey = cacheUseRecord.remove(cacheUseRecord.size() - 1);
            if(cacheKey!=null) {
                cacheEntryMap.remove(cacheKey);
                System.out.println("deleteLRU");        //log
            }
        }finally {
            writeLock.unlock();
        }

    }

    public Object get(Object object){

        readLock.lock();
        CacheEntry entry = null;
        try {
            entry = cacheEntryMap.get(object);
        }finally {
            readLock.unlock();
        }

        //更新缓存访问时间
        touchCache(entry);

        //更新使用记录
        touchUseRecord(object);

        return entry == null ? null : entry.value;

    }

    private void touchCache(CacheEntry cacheEntry){

        if(cacheEntry==null)
            return;

        writeLock.lock();
        try {
            cacheEntry.setLastTouchTime(System.currentTimeMillis());
        }finally {
            writeLock.unlock();
        }
    }

    private void touchUseRecord(Object object){

        if(object==null)
            return;

        writeLock.lock();
        try {
            //删除使用记录
            cacheUseRecord.remove(object);
            //新增使用记录
            cacheUseRecord.add(0, object);
        }finally {
            writeLock.unlock();
        }

    }

    private class CacheEntry{
        private long lastTouchTime;

        private Object value;
        public long getLastTouchTime() {
            return lastTouchTime;
        }

        public void setLastTouchTime(long lastTouchTime) {
            this.lastTouchTime = lastTouchTime;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
        public CacheEntry(Object value) {
            this.value = value;
            this.lastTouchTime = System.currentTimeMillis();
        }
    }

    //定时清除任务类
    private class ClearCacheTask extends Thread {
        public ClearCacheTask() {
            super.setName("clear cache task start...");
        }

        @Override
        public void run() {

            while (clearExpireCacheEnable){

                long now = System.currentTimeMillis();

                //定时清理任务
                try {
                    Thread.sleep(10  );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for(Map.Entry<Object, CacheManager.CacheEntry> entrySet:cacheEntryMap.entrySet()){

                    try {
                        writeLock.lock();

                        //判断key是否存在缓存中
                        if(!cacheUseRecord.contains(entrySet.getKey())){
                            return;
                        }
                        //超过过期时间
                        if(now - entrySet.getValue().getLastTouchTime() >= cacheTimeout)
                        {
                            cacheUseRecord.remove(entrySet.getKey());
                            cacheEntryMap.remove(entrySet.getKey());
                            System.out.println("清理缓存--key:"+entrySet.getKey()+"--val:"+entrySet.getValue().getValue());     //log
                        }

                    }finally {
                        writeLock.unlock();
                    }

                    try {
                        Thread.sleep(cacheTimeout);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {


        final CacheManager cacheMangerInstance = CacheManager.getCacheMangerInstance();

        cacheMangerInstance.init(10L);


        new Thread() {
            @Override
            public void run() {
                for(int i = 0; i < 85 ; i++){
                    try {
                        cacheMangerInstance.put("Thread"+i, "val-Thread-"+i);
                        Thread.sleep(10);
                    } catch (Exception e) {
                        System.out.println("Thread - error"+e.getStackTrace());
                    }
                }
            }
        }.start();

        for (int i = 0; i < 85 ; i++) {
            cacheMangerInstance.put("main"+i, "val-main-"+i);
            Thread.sleep(10);
        }


    }

}
