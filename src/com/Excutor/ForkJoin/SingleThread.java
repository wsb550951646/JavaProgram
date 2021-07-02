package com.Excutor.ForkJoin;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/12/111:05
 *
 *
 *
 * 业务场景：
 *
 *  假设一个业务场景，数据库中0-1千万会员信息，统计所有会员余额综合。
 *
 *  为了比对结果一致，余额就是使用编号，每次都从数据库查询。
 *
 *  每次查询5000 条数据
 *
 *  直到所有统计完成，进行汇总。比较单线程和Fork-Join的差异。
 *
 */
public class SingleThread {

    private static final Integer THRESHOLD = 5000;

    private static final long MAX = 100000000;

    private static final long MIN = 0;

    public static void main(String[] args) {

        long start = MIN;
        long end = MAX;
        long sum = 0;
        long time = 0;
        while ( start <= end ){
            long beginTime = System.currentTimeMillis();
            sum = sum + findData(start,start+THRESHOLD);
            start = start + THRESHOLD;
            long endTime = System.currentTimeMillis();
            time = (endTime - beginTime)+time;
        }
        System.out.println("total:"+sum +"  time:"+time);
    }

    public static long findData(long start, long end){
        // 模拟查询数据库
        try {
            long result = 0;
            //Thread.sleep(15);
            while(start <= end){
                result = result + start;
                start++;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


}
