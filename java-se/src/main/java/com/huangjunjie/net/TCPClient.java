package com.huangjunjie.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author sober 2020-05-27-10:38
 *
 *      TCP通信的客户端：向服务端发送连接请求，给服务端发送数据，读取服务端回写的数据
 *
 *      java中java.net.Socket是表示TCP通信的客户端的类
 *
 *      实现步骤：
 *      1.创建一个客户端对象即Socket对象，在构造方法中绑定服务端的IP地址和端口号
 *      2.使用Socket对象中的方法getOutputStream()获取到网络字节输出流OutputStream对象
 *      3.使用网络字节输出流OutputStream对象中的方法writer()给服务端发送数据
 *      4.使用Socket对象中的方法getInputStream()获取到网络字节输入流InputStream对象
 *      5.使用网络字节输入流InputStream对象中的方法read()来读取服务端回写的数据
 *      6.释放资源（Socket对象）
 *
 *      注意：
 *      1.客户端和服务端进行数据交互，必须使用Socket中提供的IO流，不能使用自己创建的流对象
 *      2.当我们创建客户端对象（即Socket对象）时，就会去请求客户端对象中绑定的服务端并且经过3次握手建立连接通路，这时如果服务端没有
 *        启动，那么就会客户端就会抛出异常连接失败，如果服务端已经启动，那么客户端就可以与服务端进行交互了
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1.创建一个客户端对象即Socket对象，在构造方法中绑定服务端的IP地址和端口号
        Socket socket=new Socket("127.0.0.1",8888);

        //2.使用Socket对象中的方法getOutputStream()获取到网络字节输出流OutputStream对象
        OutputStream os = socket.getOutputStream();

        //3.使用网络字节输出流OutputStream对象中的方法writer()给服务端发送数据
        os.write("hello server".getBytes());

        //4.使用Socket对象中的方法getInputStream()获取到网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();

        //5.使用网络字节输入流InputStream对象中的方法read()来读取服务端回写的数据
        byte[] byteBuffer=new byte[1024];
        int len = is.read(byteBuffer);
        System.out.println(new String(byteBuffer,0,len));

        //6.释放资源（Socket对象）
        socket.close();
    }
}
