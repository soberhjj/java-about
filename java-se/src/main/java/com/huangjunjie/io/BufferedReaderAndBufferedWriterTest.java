package com.huangjunjie.io;

import java.io.*;

/**
 * @author sober 2020-05-26-16:03
 *
 *    BufferedReader、BufferedWriter --- 字符缓冲流，与字节缓冲流BufferedInputStream、BufferedOutputStream意义一样。
 */
public class BufferedReaderAndBufferedWriterTest {
    public static void main(String[] args) {
        //创建源
        File file1 = new File("IO流API测试数据源" + File.separator + "hello.txt");
        File file2 = new File("IO流API测试数据源" + File.separator + "hello5.txt");

        //选择流
        BufferedReader br=null;
        BufferedWriter bw=null;
        try {
            br=new BufferedReader(new FileReader(file1));
            bw=new BufferedWriter(new FileWriter(file2));

            //操作
            char[] charBuffer=new char[10];
            String line=null;
            while ((line=br.readLine())!=null){  //BufferedReader中提供了这种按行读取的方式
                bw.write(line);
                bw.newLine();   //这里要调用BufferedWriter中提供的newLine()方法进行换行
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
