package com.huangjunjie.io;

import org.junit.Test;

import java.io.*;

/**
 * @author huangJunJie 2020-11-28-22:35
 * <p>
 * 数据流：DataInputStream、DataOutputStream
 * DataInputStream可以将 java的八大基本数据类型和字符串 进行保存（保存到内存或者持久化到磁盘文件），也就是说在保存数据的同时会将数据类型一起保存
 * 然后后续可以通过DataOutputStream读取数据，由于保留了类型，所以读过来后不需要类型强转，但是要保证读出的顺序和写入的顺序要保持一致
 */
public class DataInputOutputStream {

    @Test
    public void testDataInputOutputStream() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeBoolean(true);
        dos.writeByte(100);
        dos.writeChar('a');
        dos.writeUTF("hello world");
        byte[] datas = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(datas);
        DataInputStream dis = new DataInputStream(bais);
        boolean res1 = dis.readBoolean();
        byte res2 = dis.readByte();
        char res3 = dis.readChar();
        String res4 = dis.readUTF();
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }
}
