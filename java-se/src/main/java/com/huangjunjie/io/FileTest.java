package com.huangjunjie.io;

import java.io.File;
import java.io.IOException;

/**
 * @author sober 2020-05-25-16:34
 *
 * File类详解参考博文：https://blog.csdn.net/weixin_43691058/article/details/104868013
 */
public class FileTest {
    public static void main(String[] args) {

        //测试File的三种构造器
        File file1=new File("IO流API测试数据源"+File.separator+"hello.txt");
        File file2=new File("IO流API测试数据源","文件夹1");
        File file3=new File(file2,"hi.txt");

//        System.out.println(file1);
//        System.out.println(file2);
//        System.out.println(file3);

        //测试File的几个常用方法
        File file4=new File("IO流API测试数据源"+File.separator+"hello.txt");
        System.out.println(file4.getAbsoluteFile()); //getAbsoluteFile()获取绝对路径
        System.out.println(file4.getPath());//getPath()获取相对路径
        System.out.println(file4.getName());//getName()获取file所代表的文件或目录的名称
        System.out.println(file4.getParent());//getParent()获取file所代表的文件或目录的上一级目录
        System.out.println(file4.length());//如果file所代表的是一个文件，那么length()获取该文件的长度，如果file所代表的是一个目录,那么不能获取目录的长度
        System.out.println(file4.lastModified());//lastModified()获取最后一次修改时间

        File file5=new File("IO流API测试数据源");
        String[] list = file5.list(); //list()获取指定目录下的所有文件或文件目录的名称数组
        for (String s:list)
            System.out.println(s);

        File[] file6 = file5.listFiles(); //listFiles()获取指定目录下的所有文件或文件目录的File数组。
        for (File file:file6)
            System.out.println(file);

        //文件重命名
//        File file7=new File("IO流API测试数据源"+File.separator+"文件夹1"+File.separator+"waitRename.txt");
//        file7.renameTo(new File("IO流API测试数据源"+File.separator+"文件夹1"+File.separator+"rename.txt"));

        //创建文件、文件夹
        File file8=new File("IO流API测试数据源"+File.separator+"文件夹1"+File.separator+"newFile.txt");
        if (!file8.exists()){
            try {
                file8.createNewFile();
                System.out.println("文件创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else
            System.out.println("文件创建失败");

        File file9=new File("IO流API测试数据源"+File.separator+"文件夹4");
        if (file9.mkdir())
            System.out.println("文件夹创建成功");

        //删除文件、文件夹
        File file10=new File("IO流API测试数据源"+File.separator+"文件夹1"+File.separator+"newFile.txt");
        if (file10.delete())
            System.out.println("文件删除成功");

        File file11=new File("IO流API测试数据源"+File.separator+"文件夹4");
        if (file11.delete())
            System.out.println("文件夹删除成功");
    }
}
