package com.huangjunjie.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * @author huangJunJie 2020-11-28-18:00
 */
public class FileInputOutputStreamDemo {


    /**
     * 使用字节流操作文本文件，当文本文件中含有中文字符时会因为字符编码的问题而出现乱码。
     * 因此虽然字节流也可以处理文本文件，但是存字符编码问题，所以处理文本文件应该用字符流，字符流就是为专门处理文本文件而存在的。
     * @throws IOException
     */
    @Test
    public void testFileInputStream() throws IOException {
        File file = new File("src\\main\\resources\\hello.txt");
        FileInputStream fis=new FileInputStream(file);
        byte[] buffer=new byte[5];
        int len;
        while ((len=fis.read(buffer))!=-1){
            String s=new String(buffer,0,buffer.length);
            System.out.println(s);
        }
    }

    /**
     * 复制图片
     */
    @Test
    public void testFileInputOutPutStream() throws IOException{
        File fileIn=new File("src\\main\\resources\\宋智孝.jpg");
        File fileOut=new File("src\\main\\resources\\宋智孝_copy.jpg");
        FileInputStream fis=new FileInputStream(fileIn);
        FileOutputStream fos=new FileOutputStream(fileOut);
        byte [] buffer=new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        fis.close();
        fos.close();

    }
}
