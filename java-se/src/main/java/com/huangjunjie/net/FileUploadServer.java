package com.huangjunjie.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sober 2020-05-27-16:37
 *
 *      文件上传案例的服务端：读取客户端发送过来的文件数据，保存到服务端本地硬盘，给客户端回写“上传成功”
 *
 *      数据源：客户端发送过来的文件数据
 *      目的地：服务端本地硬盘，这里就指定为项目路径下的 “IO流API测试数据源\\服务端从客户端得到的图片.jpg”
 *
 *      实现步骤：
 *      1.创建一个服务端对象即ServerSocket对象,在构造方法中要指定该服务端程序的端口号
 *      2.使用ServerSocket对象中的方法accept(),获取到请求的客户端对象即Socket对象
 *      3.使用Socket对象中的方法getInputStream()获取到网络字节输入流InputStream对象
 *      4.创建一个本地字节输出流FileOutputStream对象，目的地见上述
 *      5.使用网络字节输入流InputStream对象中的方法read()来读取客户端发送的数据
 *      6.使用地字节输出流FileOutputStream对象中的方法write()将5中读取到的数据保存到服务端本地硬盘
 *      7.使用Socket对象中的方法getOutputStream()获取到网络字节输出流OutputStream对象
 *      8.使用网络字节输出流OutputStream对象中的方法writer()给客户端回写“上传成功”
 *      9.释放资源（FileOutputStream对象、Socket对象和ServerSocket对象）
 */
public class FileUploadServer {
    public static void main(String[] args) throws IOException {
        //创建一个服务端对象即ServerSocket对象,在构造方法中要指定该服务端程序的端口号
        ServerSocket serverSocket=new ServerSocket(10001);

        //使用ServerSocket对象中的方法accept(),获取到请求的客户端对象即Socket对象
        Socket socket = serverSocket.accept();

        //使用Socket对象中的方法getInputStream()获取到网络字节输入流InputStream对象
        InputStream netis = socket.getInputStream();

        //创建一个本地字节输出流FileOutputStream对象，目的地见上述
        File file=new File("IO流API测试数据源"+File.separator+"服务端从客户端得到的图片.jpg");
        OutputStream os=new FileOutputStream(file);

        //使用网络字节输入流InputStream对象中的方法read()来读取客户端发送的数据
        byte[] byteBuffer=new byte[1024];
        int len=-2;
        while ((len=netis.read(byteBuffer))!=-1){
            //使用地字节输出流FileOutputStream对象中的方法write()将5中读取到的数据保存到服务端本地硬盘
            os.write(byteBuffer,0,len);
        }

        //由于客户端中调用了socket.shutdownOutput()表明了客户端数据发送完毕，所以上面的while循环中的read()方法会在读取完客户端发送
        //来的文件数据后读取到结束标记返回-1，从而结束while循环继续向下执行代码。如果客户端中没有调用socket.shutdownOutput()的话，
        //那么上面的while循环中的read()方法就不会读取到结束标记也就不会返回-1，所以会陷入在while循环中。

        //使用Socket对象中的方法getOutputStream()获取到网络字节输出流OutputStream对象
        OutputStream netos = socket.getOutputStream();

        //使用网络字节输出流OutputStream对象中的方法writer()给客户端回写“上传成功”
        netos.write("上传成功".getBytes());

        //释放资源
        os.close();
        socket.close();
        serverSocket.close();
    }
}
