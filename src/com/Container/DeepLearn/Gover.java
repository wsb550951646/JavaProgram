package com.Container.DeepLearn;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2610:19
 */
public class Gover implements Generator<String> {

    private String[] name = ("strang xxx aaaa woman man str test asdfa 1111 22222 333 444").split(" ");

    private int index = 0;

    @Override
    public String next() {
        return name[++index];
    }
}
