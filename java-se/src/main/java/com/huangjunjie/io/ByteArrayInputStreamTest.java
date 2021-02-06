package com.huangjunjie.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author sober 2020-05-26-9:06
 *
 *   ByteArrayInputStream、ByteArrayOutputStream ----字节数组流
 *
 *   什么是字节数组流？字节数组流本质上指向的就是程序内存中的一个字节数组，所以它不像FileInputStream流涉及到系统资源，FileInputStream流指向的是系统文件。
 */
public class ByteArrayInputStreamTest {
    public static void main(String[] args) throws IOException {

        //创建源
        byte[] src = "I want to share one lifetime with you".getBytes();

        //选择流
        InputStream is=new ByteArrayInputStream(src);

        //操作
        byte[] byteBuffer=new byte[5];//缓冲容器
        int len=-2;
        while ((len=is.read(byteBuffer))!=-1){
            System.out.println(new String(byteBuffer));
        }
        is.close();

    }
}
