package com.DeepDesignPattern.CommandPattern;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2415:59
 */
public class RemoteController {


    public static final Integer REMOTE_NUM = 5;
    private Command[] OnCommand = new Command[REMOTE_NUM];
    private Command[] OffCommand = new Command[REMOTE_NUM];
    private Command previewCommand;

    public RemoteController() {

        for (int i = 0; i < REMOTE_NUM; i++) {
            OnCommand[i] = new NoCommand();
            OffCommand[i] = new NoCommand();
            previewCommand = new NoCommand();
        }
    }

    public void SetCommand(int no,Command OnCommand,Command OffCommand){

        if(no > REMOTE_NUM || no < 0)
            return;

        this.OnCommand[no] = OnCommand;
        this.OffCommand[no] = OffCommand;

    }

    public void button_on(int no){

        previewCommand = this.OnCommand[no];
        this.OnCommand[no].execute();

    }

    public void button_off(int no){

       previewCommand= this.OffCommand[no];
       this.OffCommand[no].execute();

    }

    public void button_undo(){

        previewCommand.undo();

    }


}
