package com.huangjunjie.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author sober 2020-05-25-21:01
 *
 *    FileInputStream--文件字节流
 */
public class FileInputStreamTest2 {
    public static void main(String[] args) {
        //创建源
        File file = new File("IO流API测试数据源" + File.separator + "hello1.txt");
        InputStream is = null;
        try {
            //选择流
            is = new FileInputStream(file);

            //读取操作--将英文文本中的字母读取出来，每次读取byte[10]即每次读取10个字节
            byte[] byteBuffer = new byte[10];//缓冲容器
            int len = -2;//读取的字节的个数
            while ((len = is.read(byteBuffer)) != -1) {
                //字节数组->字符串
                System.out.println(new String(byteBuffer));
            }
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
