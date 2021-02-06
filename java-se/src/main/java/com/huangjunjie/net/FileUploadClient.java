package com.huangjunjie.net;

import java.io.*;
import java.net.Socket;

/**
 * @author sober 2020-05-27-16:15
 *
 *      文件上传案例的客户端：读取本地文件，上传到服务端，读取服务端回写的数据
 *
 *      数据源：项目路径下的 “IO流API测试数据源\\文件上传案例测试图片.jpg”
 *      目的地：服务端
 *
 *      实现步骤：
 *      1.创建一个本地字节输入流FileInputStream对象，数据源见上述
 *      2.创建一个客户端对象即Socket对象，在构造方法中绑定服务端的IP地址和端口号
 *      3.使用Socket对象中的方法getOutputStream()获取到网络字节输出流OutputStream对象
 *      4.使用本地字节输入流FileInputStream对象中的方法read()读取本地文件数据
 *      5.使用网络字节输出流OutputStream对象中的方法writer()将4中读取到的文件数据发送给服务端
 *      6.使用Socket对象中的方法getInputStream()获取到网络字节输入流InputStream对象
 *      7.使用网络字节输入流InputStream对象中的方法read()来读取服务端回写的数据
 *      8.释放资源（FileInputStream对象、Socket对象）
 */
public class FileUploadClient {
    public static void main(String[] args) throws IOException {
        //数据源
        File file=new File("IO流API测试数据源"+File.separator+"文件上传案例测试图片.jpg");

        //创建本地字节输入流
        InputStream is=new FileInputStream(file);

        //创建一个客户端对象即Socket对象，在构造方法中绑定服务端的IP地址和端口号
        Socket socket=new Socket("127.0.0.1",10001);

        //使用Socket对象中的方法getOutputStream()获取到网络字节输出流OutputStream对象
        OutputStream netos = socket.getOutputStream();

        //使用本地字节输入流FileInputStream对象中的方法read()读取本地文件数据
        byte[] byteBuffer=new byte[1024];
        int len=-2;
        while ((len=is.read(byteBuffer))!=-1){
            //使用网络字节输出流OutputStream对象中的方法writer()将4中读取到的文件数据发送给服务端
            netos.write(byteBuffer,0,len);
        }

        socket.shutdownOutput();//调用该方法用来表明客户端的数据发送完毕，客户端不再发送更多数据

        //使用Socket对象中的方法getInputStream()获取到网络字节输入流InputStream对象
        InputStream netis = socket.getInputStream();
        while ((len=netis.read(byteBuffer))!=-1){
            System.out.println(new String(byteBuffer,0,len));
        }

        //释放资源
        is.close();
        socket.close();
    }
}
