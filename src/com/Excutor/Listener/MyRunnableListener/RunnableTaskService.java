package com.Excutor.Listener.MyRunnableListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/11/1811:25
 */
public class RunnableTaskService implements RunnableStatusListener{

    private List<TaskRunnable> taskRunnables = new ArrayList<>();

    public void startTask(){

        List<String> ThreadName = Arrays.asList("任务1","任务2","异常任务");
        for (String name : ThreadName) {
            TaskRunnable taskRunnable = new TaskRunnable(name);
            taskRunnable.addListener(this);
            taskRunnables.add(taskRunnable);
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        for(TaskRunnable task : taskRunnables) {
            executorService.execute(task);
        }
    }

    public static void main(String[] args) {
        RunnableTaskService taskService = new RunnableTaskService();
        taskService.startTask();
    }

    @Override
    public void onstatusChanged(String ThreadName, String state) {
        System.out.println("任务运行状态监听 名称:"+ThreadName+" 状态:"+state);
    }
}
