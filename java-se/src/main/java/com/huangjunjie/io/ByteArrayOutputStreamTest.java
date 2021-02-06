package com.huangjunjie.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author sober 2020-05-26-9:26
 *
 *      ByteArrayInputStream、ByteArrayOutputStream ----字节数组流
 */
public class ByteArrayOutputStreamTest {
    public static void main(String[] args) {

        //创建源
        byte[] destination=null; //字节数组输出流不需要指定目的地，由于输出目的地是内存，所以应该由流本身根据数据的多少来自己决定开辟多大的内存，且这个内存会随着数据的写入自动增长

        //选择流
//        OutputStream os=new ByteArrayOutputStream();
        ByteArrayOutputStream baos=new ByteArrayOutputStream(); //因为要使用ByteArrayOutputStream中的新增方法（该方法在父类OutputStream中没有），所以这里不使用多态，也就是不使用上一行代码

        //操作（写入）
        byte[] datas = "I want to share one lifetime with you".getBytes();
        try {
            baos.write(datas);
            baos.flush(); //这里要进行flush,因为ByteArrayOutputStream的释放方法close是个空方法，所以没必要调用close，调用了也没用
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取数据
        destination=baos.toByteArray();
        System.out.println(new String(destination));


    }
}
