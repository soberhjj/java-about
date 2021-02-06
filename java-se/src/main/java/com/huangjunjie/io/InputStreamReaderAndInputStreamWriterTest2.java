package com.huangjunjie.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author sober 2020-05-26-16:46
 */
public class InputStreamReaderAndInputStreamWriterTest2 {
    public static void main(String[] args) throws IOException {
        //数据源为百度首页的源代码
        BufferedReader br = new BufferedReader(new InputStreamReader(new URL("https://www.baidu.com/").openStream(),"utf-8")); //new URL("https://www.baidu.com/").openStream()是一个网络的字节流，new InputStreamReader(System.in)即将字节流转换成字符流，然后又在这个字符流的基础上创建了字符缓冲流

        try {
            String msg = null;
            while ((msg=br.readLine())!=null) {
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
