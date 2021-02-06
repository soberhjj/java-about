package com.huangjunjie.io;

import java.io.*;

/**
 * @author sober 2020-05-26-7:53
 *
 *  FileReader、FileWriter--字符流（字符流只能处理文本类型文件）
 *
 *  将hello.txt（纯中文字符文本文件）中的全部字符复制到hello3.txt
 */
public class FileReaderAndFileWriterTest {
    public static void main(String[] args) {
        //创建源
        File file1=new File("IO流API测试数据源"+File.separator+"hello.txt");
        File file2=new File("IO流API测试数据源"+File.separator+"hello3.txt");

        //选择流
        Reader reader=null;
        Writer writer=null;
        try {
            reader=new FileReader(file1);
            writer=new FileWriter(file2);
            char[] bufferChar=new char[5];
            int len=-2;
            while ((len=reader.read(bufferChar))!=-1){
               writer.write(bufferChar);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
