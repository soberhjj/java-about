package com.huangjunjie.io;

import java.io.*;

/**
 * @author sober 2020-05-25-21:27
 *
 *    FileInputStream--文件字节流   FileOutputStream--文件字节流
 *
 *  将 hello1.txt（英文文本）中的全部字符复制到 hello2.txt
 */
public class FileOutputStreamTest {
    public static void main(String[] args) {
        //创建源(文本类型数据源)
        File file1=new File("IO流API测试数据源" + File.separator + "hello1.txt");//输入数据源
        File file2=new File("IO流API测试数据源" + File.separator + "hello2.txt");//输出目的地

        //创建源(图片类型数据源)
//        File file1=new File("IO流API测试数据源" + File.separator + "IO测试图片.jpg");//输入数据源
//        File file2=new File("IO流API测试数据源" + File.separator + "IO复制生成的新的图片.jpg");//输出目的地

        //选择流
        InputStream is=null;
        OutputStream os=null;
        try {
            is=new FileInputStream(file1);
            os=new FileOutputStream(file2,true);//true表示追加写入，默认为false覆盖写入

            //每次从file1读取10个字节并写入file2
            byte[] byteBuffer=new byte[10];
            int len=-2;
            while ((len=is.read(byteBuffer))!=-1)
                os.write(byteBuffer);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源，分别关闭，先打开的后关闭
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
