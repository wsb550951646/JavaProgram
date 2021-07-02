package com.Enum;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/1/1918:42
 */
public class TotalTask {

    private Task status;

    public TotalTask(Task status) {
        this.status = status;
    }

    public Task getStatus() {
        return status;
    }

    public void setStatus(Task status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TotalTask{" +
                "status=" + status +
                '}';
    }
}
