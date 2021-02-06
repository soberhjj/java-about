package com.huangjunjie.io;

import java.io.*;

/**
 * @author sober 2020-05-25-20:40
 *
 *   FileInputStream--文件字节流
 */
public class FileInputStreamTest1 {
    public static void main(String[] args) {
        //创建源
        File file = new File("IO流API测试数据源" + File.separator + "hello1.txt");
        //选择流
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            //读取操作
//            int byte1 = is.read();//读取第一个字节
//            int byte2 = is.read();//读取第二个字节
//            int byte3 = is.read();//读取第三个字节
//            System.out.println((char) byte1);
//            System.out.println((char) byte2);
//            System.out.println((char) byte3);

            //读取操作--将英文文本中的字母一个一个字节的读取出来
            int temp = -2;
            while ((temp = is.read()) != -1) {
                System.out.print((char) temp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
