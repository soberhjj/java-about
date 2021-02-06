package com.huangjunjie.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sober 2020-05-27-11:13
 *
 *       TCP通信的服务端：接收客户端连接请求，读取客户端发送的数据，给客户端回写数据
 *
 *       java中java.net.ServerSocket是表示TCP通信的服务端的类
 *
 *       实现步骤：
 *       1.创建一个服务端对象即ServerSocket对象,在构造方法中要指定该服务端程序的端口号
 *       2.使用ServerSocket对象中的方法accept(),获取到请求的客户端对象即Socket对象
 *       3.使用Socket对象中的方法getInputStream()获取到网络字节输入流InputStream对象
 *       4.使用网络字节输入流InputStream对象中的方法read()来读取客户端发送的数据
 *       5.使用Socket对象中的方法getOutputStream()获取到网络字节输出流OutputStream对象
 *       6.使用网络字节输出流OutputStream对象中的方法writer()给客户端回写数据
 *       7.释放资源（Socket对象和ServerSocket对象）
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1.创建一个服务端对象即ServerSocket对象,在构造方法中要指定该服务端程序的端口号
        ServerSocket serverSocket=new ServerSocket(8888);

        //2.使用ServerSocket对象中的方法accept(),获取到请求的客户端对象即Socket对象
        Socket socket = serverSocket.accept();

        //3.使用Socket对象中的方法getInputStream()获取到网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();

        //4.使用网络字节输入流InputStream对象中的方法read()来读取客户端发送的数据
        byte[] byteBuffer=new byte[1024];
        int len = is.read(byteBuffer);
        System.out.println(new String(byteBuffer,0,len));

        //5.使用Socket对象中的方法getOutputStream()获取到网络字节输出流OutputStream对象
        OutputStream os = socket.getOutputStream();

        //6.使用网络字节输出流OutputStream对象中的方法writer()给客户端回写数据
        os.write("hello client，I have get your message".getBytes());

        //7.释放资源（Socket对象和erverSocket对象）
        socket.close();
        serverSocket.close();
    }
}
