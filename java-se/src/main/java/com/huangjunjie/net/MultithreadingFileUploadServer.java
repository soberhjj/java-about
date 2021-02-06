package com.huangjunjie.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * @author sober 2020-05-27-22:18
 * <p>
 * OptimizeFileUploadServer只能一个接一个的接收客户端发来的数据完成文件上传，也就是说服务端只能在完成上一个客户端的文件上传
 * 后才能继续处理下一个客户端的文件上传。现在需求来了，如何使服务端能够同时进行多个客户端的文件上传呢？答案当然是使用多线程
 */
public class MultithreadingFileUploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10001);
        while (true) {
            final Socket socket = serverSocket.accept();
            new Thread(new Runnable() {
                //完成文件上传
                public void run() {
                    InputStream netis = null;
                    try {
                        netis = socket.getInputStream();

                        String fileName = "image" + System.currentTimeMillis() + (new Random().nextInt(666888) + ".jpg");//文件命名
                        File file = new File("IO流API测试数据源" + File.separator + fileName);
                        OutputStream os = new FileOutputStream(file);

                        byte[] byteBuffer = new byte[1024];
                        int len = -2;
                        while ((len = netis.read(byteBuffer)) != -1) {
                            os.write(byteBuffer, 0, len);
                        }

                        OutputStream netos = socket.getOutputStream();

                        netos.write("上传成功".getBytes());

                        os.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


        }
    }
}
