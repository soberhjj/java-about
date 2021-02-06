package com.huangjunjie.io;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author sober 2020-11-28-13:32
 */
public class FileReaderWriterDemo {

    @Test
    public void testFileReader1() throws IOException {
        File file = new File("src\\main\\resources\\hello.txt");
        FileReader fr = new FileReader(file);
        //开始读数据（一次读入一个字符）
        int data;
        while ((data=fr.read()) != -1){
            System.out.println((char) data);
        }
        fr.close();
    }

    @Test
    public void testFileReader2() throws IOException {
        File file = new File("src\\main\\resources\\hello.txt");
        FileReader fr = new FileReader(file);
        //开始读数据（一次读入多个字符）
        char [] cbuf=new char[5];
        int data;
        while ((data=fr.read(cbuf)) != -1){
            for (int i=0;i<data;i++){
                System.out.println(cbuf[i]);
            }
        }
        fr.close();
    }

    /**
     * 将内存中的数据写到硬盘文件
     */
    @Test
    public void testFileWritter() throws IOException{
        File file = new File("src\\main\\resources\\hello.txt");
        //设置为追加写入
        FileWriter fw=new FileWriter(file,true);
        //开始写数据
        fw.write("\r\nhello china! \r\n你好中国!");
        fw.close();
    }
}
