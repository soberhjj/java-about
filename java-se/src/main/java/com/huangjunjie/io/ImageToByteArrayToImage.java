package com.huangjunjie.io;

import java.io.*;

/**
 * @author sober 2020-05-26-9:51
 *
 *  要求：1.将图片读取到字节数组中
 *       2.将字节数组还原成图片
 */
public class ImageToByteArrayToImage {
    public static void main(String[] args) {
        /**
         * 1.将图片读取到字节数组中
         */
        File file1=new File("IO流API测试数据源"+File.separator+"IO测试图片.jpg");
        File file2=new File("IO流API测试数据源"+File.separator+"ImageToByteArrayToImage.jpg");

        byte[] imageBytes=imageFileToByteArray(file1);
        byteArrayToImageFile(imageBytes,file2);
    }

    //读取图片并写出到字节数组中
    public static byte[] imageFileToByteArray(File file){
        InputStream is=null;
        try {
            //选择流
            is=new FileInputStream(file);
            ByteArrayOutputStream baos=new ByteArrayOutputStream(); //ByteArrayOutputStream无需关闭，故直接在这里定义并初始化


            //操作（将图片的字节数据写入字节数组流）
            byte[] byteBuffer=new byte[1024];//缓冲容器，大小1KB
            int len=-2;
            while ((len=is.read(byteBuffer))!=-1){
                baos.write(byteBuffer);
            }
            baos.flush();

            //从字节数组流中拿到图片的字节数据
            byte[] imageBytes = baos.toByteArray();
            return imageBytes;

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //将字节数组还原成图片文件
    public static void byteArrayToImageFile(byte[] imageBytes,File file){
        OutputStream os=null;
        try {
            os=new FileOutputStream(file);
            InputStream is=new ByteArrayInputStream(imageBytes);// ByteArrayInputStream无需关闭，故直接在这里定义并初始化

            byte[] byteBuffer=new byte[1024];//缓冲容器，大小1KB
            int len=-2;
            while ((len=is.read(byteBuffer))!=-1){
                os.write(byteBuffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
