package com.huangjunjie.thumbnailator;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author: huangJunJie  2021-02-08 09:21
 *
 *      获取图片的字节数组
 */
public class AcquireImageBytesUtils {

    /**
     * 根据网络图片的url ，获取该网络图片的字节数组
     * @param url:网络图片的url
     */
    public static byte[] getNetImageByte(String url) throws IOException {
        URL urlConet = new URL(url);
        HttpURLConnection con = (HttpURLConnection)urlConet.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(4 * 1000);
        //通过输入流获取图片数据
        InputStream inStream = con .getInputStream();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[2048];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        byte[] data =  outStream.toByteArray();
        outStream.close();
        return data;
    }

    /**
     * 根据本地图片的路径 ，获取该本地图片的字节数组
     * @param path: 本地图片路径
     */
    public static byte[] getLocalImageByte(String path) throws IOException{
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(path));
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024);

        byte[] temp = new byte[2048];
        int size = 0;
        while ((size = in.read(temp)) != -1) {
            out.write(temp, 0, size);
        }
        in.close();
        byte[] content = out.toByteArray();
        out.close();
        return content;
    }

    /**
     * 根据图片的字节数组，将图片存储到本地
     * @param imageByte：图片的字节数组
     * @param path：存储的本地路径
     */
    public static void saveImageToLocal(byte[] imageByte,String path) throws IOException {
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(path));
        bos.write(imageByte);
        bos.close();
    }
}
