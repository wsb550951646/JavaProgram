package com.DeepDesignPattern.CommandPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2415:54
 */
public class LightOnCommand implements Command {

    private LightReceived received;

    public LightOnCommand(LightReceived received) {
        this.received = received;
    }

    @Override
    public void execute() {

        received.On();

    }

    @Override
    public void undo() {

        received.Off();
    }
}
