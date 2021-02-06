package com.huangjunjie.io;

import org.junit.Test;

import java.io.*;

/**
 * @author huangJunJie 2020-11-28-20:18
 * <p>
 * 缓冲流：BufferedInputStream、BufferedOutputStream、BufferedReader、BufferedWriter
 */
public class BufferedTest {

    @Test
    public void testBufferedInputOutputStream() throws IOException {
        File fileIn = new File("src\\main\\resources\\宋智孝.jpg");
        File fileOut = new File("src\\main\\resources\\宋智孝_copy1.jpg");

        FileInputStream fis=new FileInputStream(fileIn);
        FileOutputStream fos=new FileOutputStream(fileOut);

        BufferedInputStream bis=new BufferedInputStream(fis);
        BufferedOutputStream bos=new BufferedOutputStream(fos);

        byte [] buffer=new byte[1024];
        int len;
        while ((len=bis.read(buffer))!=-1){
            bos.write(buffer,0,len);
        }

        //关闭外层流的同时，内层流也会自动的进行关闭。
        bis.close();
        bos.close();
    }

    @Test
    public void testBufferedReaderWriter() throws IOException{
        File fileIn = new File("src\\main\\resources\\hello.txt");
        File fileOut = new File("src\\main\\resources\\hello_copy.txt");

        BufferedReader br=new BufferedReader(new FileReader(fileIn));
        BufferedWriter bw=new BufferedWriter(new FileWriter(fileOut));

        char [] cbuf=new char[2];
        int len;
        while ((len=br.read(cbuf))!=-1){
            bw.write(cbuf,0,len);
        }

        br.close();
        bw.close();
    }


}
