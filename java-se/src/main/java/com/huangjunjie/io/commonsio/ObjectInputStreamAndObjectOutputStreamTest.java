package com.huangjunjie.io.commonsio;

import java.io.*;

/**
 * @author sober 2020-05-26-20:35
 * <p>
 * ObjectInputStream、ObjectOutputStream --- 对象流
 * 对象流与数据流的意义相同，数据流是方便我们处理八大基本数据类型以及字符串，而对象流则是方便我们处理引用类型
 */
public class ObjectInputStreamAndObjectOutputStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //通过ByteArrayOutputStream将数据写入到内存，在ByteArrayOutputStream基础上使用ObjectOutputStream来将引用类型数据(即对象)写入内存，这个过程也称为对象的序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(new Student("张三", 23, "江西赣州"));
        oos.writeObject(new Student("李四", 24, "江西赣州"));


        //通过ByteArrayInputStream读取内存中的数据，在ByteArrayInputStream基础上使用ObjectInputStream读取内存中的对象，这个过程也称为对象的反序列化
        ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        Student student1 = (Student) ois.readObject();
        Student student2 = (Student) ois.readObject();
        student1.showInfo();
        student2.showInfo();
    }
}

class Student implements Serializable {
    private String name;
    private int age;
    private String address;

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void showInfo() {
        System.out.println("姓名：" + name + " 年龄：" + age + " 籍贯：" + address);
    }
}
