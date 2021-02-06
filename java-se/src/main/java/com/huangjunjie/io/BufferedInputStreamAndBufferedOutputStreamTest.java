package com.huangjunjie.io;

import java.io.*;

/**
 * @author sober 2020-05-26-15:06
 * <p>
 *       BufferedInputStream、BufferedOutputStream ---字节缓冲流
 *       以读取数据为例：我们可以1个字节1个字节的读取数据，我们也可以使用一个字节数组作为缓冲容器如 byte[10] 这样10个字节10个的读取数据。
 *       而对于BufferedInputStream，在BufferedInputStream的内部会创建出一个缓冲区，这个缓冲区的大小默认为8KB,
 *       我们以字节数组byte[10]作为缓冲容器，那么当调用BufferedInputStream的read方法时，它会每次10个字节的读取数据然后将
 *       这10个字节放入BufferedInputStream的缓冲区，而且调用一次read，它会尽可能多的读取更多字节，比如读了5次10个字节，将这50个字节
 *       全部放入缓冲区。程序中要用到数据时先去缓冲区获取，如缓冲区中已没有数据，这时会再去调用read去磁盘中读取数据到缓冲区供程序使用。
 *
 *       通过上一段可以看出，对于同一个文件，如果1个字节1个字节的读取文件数据，那么这种情况IO次数最频繁，
 *       如果使用一个字节数组作为缓冲容器进行多个字节多个字节的读取，那么这种情况IO次数较上面那种情况有所较少了，
 *       如果在缓冲容器的基础上再使用BufferedInputStream的话，那么这种情况IO次数是最少的。
 *
 */
public class BufferedInputStreamAndBufferedOutputStreamTest {
    public static void main(String[] args) {
        //创建源
        File file1 = new File("IO流API测试数据源" + File.separator + "hello1.txt");
        File file2 = new File("IO流API测试数据源" + File.separator + "hello4.txt");

        //选择流
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(file1));
            bos=new BufferedOutputStream(new FileOutputStream(file2));
            //操作
            byte[] byteBuffer = new byte[10]; //缓冲容器
            int len = -2;
            while ((len = bis.read(byteBuffer)) != -1) {
                bos.write(byteBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
