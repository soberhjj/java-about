package com.huangjunjie.io;

import java.io.*;

/**
 * @author sober 2020-05-26-16:23
 * <p>
 * InputStreamReader、InputStreamWriter --- 转换流 作用：将字节流转换成字符流，前提是字节流的数据是纯文本类型的数据，
 * 这样我们将字节流转换成字符流后更便于处理，同时在字节流转换成字符流时还可以指定字符集。
 */
public class InputStreamReaderAndInputStreamWriterTest1 {
    public static void main(String[] args) {
        //数据源为System.in(即键盘)、数据输出目的为System.out(即控制台)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //System.in是一个字节流，new InputStreamReader(System.in)即将字节流转换成字符流，然后又在这个字符流的基础上创建了字符缓冲流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//与上一行同理

        try {
            String msg = "";
            while (!msg.equals("exit")) {
                msg = br.readLine(); //从键盘读取
                bw.write(msg); //输出到控制台
                bw.newLine();
                bw.flush(); //强制刷新，因为如果没有强制刷新那么当数据没有填满BufferedWriter的缓冲区时不会输出
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
