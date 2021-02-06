package com.huangjunjie.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * @author sober 2020-05-27-21:02
 * <p>
 * 在FileUploadServer(即服务端)中，它只能接收一个客户端发来的数据完成文件上传，然后服务端就结束退出了，
 * 那么现在的需求是服务端永不结束退出，它能一直接收客户端发来的数据完成文件上传，也就是说它在接收一个客户端发来的数据完成文件上传后
 * 会继续等待下一个客户端，接收下一个客户端发来的数据完成文件上传。然后又继续等待下一个客户端 ...... 。服务端就这样一直运行下去。
 * <p>
 * 同时服务端为了避免同名的文件被覆盖，将定义一个文件的命名规则，文件名为：image+毫秒值+随机数
 */
public class OptimizeFileUploadServer {
    public static void main(String[] args) throws IOException {
        //创建一个服务端对象即ServerSocket对象,在构造方法中要指定该服务端程序的端口号
        ServerSocket serverSocket = new ServerSocket(10001);
        while (true) {
            //使用ServerSocket对象中的方法accept(),获取到请求的客户端对象即Socket对象
            Socket socket = serverSocket.accept();

            //使用Socket对象中的方法getInputStream()获取到网络字节输入流InputStream对象
            InputStream netis = socket.getInputStream();

            //创建一个本地字节输出流FileOutputStream对象
            String fileName = "image" + System.currentTimeMillis() + (new Random().nextInt(666888) + ".jpg");//文件命名
            File file = new File("IO流API测试数据源" + File.separator + fileName);
            OutputStream os = new FileOutputStream(file);

            //使用网络字节输入流InputStream对象中的方法read()来读取客户端发送的数据
            byte[] byteBuffer = new byte[1024];
            int len = -2;
            while ((len = netis.read(byteBuffer)) != -1) {
                //使用地字节输出流FileOutputStream对象中的方法write()将5中读取到的数据保存到服务端本地硬盘
                os.write(byteBuffer, 0, len);
            }

            //使用Socket对象中的方法getOutputStream()获取到网络字节输出流OutputStream对象
            OutputStream netos = socket.getOutputStream();

            //使用网络字节输出流OutputStream对象中的方法writer()给客户端回写“上传成功”
            netos.write("上传成功".getBytes());

            //释放资源
            os.close();
            socket.close();
        }
    }
}
