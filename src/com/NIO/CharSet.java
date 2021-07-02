package com.NIO;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/814:56
 */
public class CharSet {

    public static void main(String[] args) throws CharacterCodingException {

        Charset charset = Charset.forName("GBK");

        //编码
        CharsetEncoder charsetEncoder = charset.newEncoder();

        //解码
        CharsetDecoder charsetDecoder = charset.newDecoder();

        CharBuffer cbuff = CharBuffer.allocate(1024);

        cbuff.put("冲冲冲干干干");
        cbuff.flip();
        ByteBuffer byteBuffer = charsetEncoder.encode(cbuff);

        //按照GBK 编码 将CharBuffer cbuff 转换为 ByteBuffer  的
        for (int i = 0; i < byteBuffer.limit(); i++) {

            System.out.println(byteBuffer.get());

        }

        byteBuffer.flip();
        CharBuffer decode = charsetDecoder.decode(byteBuffer);
        System.out.println(decode.toString());


    }


}
