package com.DeepDesignPattern.CommandPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2415:57
 */
public class LightOffCommand implements Command{

    private LightReceived received;

    public LightOffCommand(LightReceived received) {
        this.received = received;
    }

    @Override
    public void execute() {
        received.Off();
    }

    @Override
    public void undo() {
        received.On();
    }
}
