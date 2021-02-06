package com.huangjunjie.io;

import java.io.*;

/**
 * @author sober 2020-05-26-19:26
 *
 *      DataInputStream、DataOutputStream --- 数据流
 *      数据流的作用是方便我们处理八大基本数据类型以及字符串，说的简单点也就是它不单保留了数据，还保留了数据类型，
 *      方便我们后续直接获取数据及其数据类型，而不用我们再对数据进行强转。
 *
 *      注意对于数据流，读取的数据的顺序要和之前写入的数据的顺序保持一致
 *
 */
public class DataInputStreamAndDataOutputStreamTest {
    public static void main(String[] args) throws IOException {
        //通过ByteArrayOutputStream将数据写入到内存，在ByteArrayOutputStream基础上使用DataOutputStream来将基本数据类型数据或字符串写入内存
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        DataOutputStream dos=new DataOutputStream(baos);
        dos.writeUTF("I want to share one lifetime with you");//写入String类型数据
        dos.writeByte(9);//写入byte类型数据
        dos.writeInt(10);//写入int类型数据
        dos.writeShort(11);//short类型数据
        dos.writeLong(12);//写入long类型数据
        dos.writeBoolean(true);//写入布尔类型数据
        dos.writeFloat(13.4f);//写入float类型数据
        dos.writeDouble(15.6);//写入double类型数据
        dos.writeChar('h');//写入char类型数据


        //通过ByteArrayInputStream读取内存中的数据，在ByteArrayInputStream基础上使用DataInputStream读取内存中的基本数据类型数据或字符串
        //注意读取的数据的顺序要和之前写入的数据的顺序保持一致。
        DataInputStream dis=new DataInputStream(new ByteArrayInputStream(baos.toByteArray()));
        System.out.println(dis.readUTF());
        System.out.println(dis.readByte());
        System.out.println(dis.readInt());
        System.out.println(dis.readShort());
        System.out.println(dis.readLong());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readFloat());
        System.out.println(dis.readDouble());
        System.out.println(dis.readChar());
    }
}
