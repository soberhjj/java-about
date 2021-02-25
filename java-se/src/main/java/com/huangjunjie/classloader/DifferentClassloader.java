package com.huangjunjie.classloader;

import org.junit.Test;

/**
 * @author huangJunJie 2021-02-23-19:56
 */
public class DifferentClassloader {

    @Test
    public void getClassloader() throws ClassNotFoundException {
        ClassLoader classLoader = Person.class.getClassLoader();
        System.out.println(classLoader);
        //输出可以看到classLoader是AppClassLoader

        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        //输出可以看到classLoader是ExtClassLoader

        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
        //输出可以看到parent1是null,可知启动类加载器是无法被Java程序直接引用到的

        Class clazz1=Person.class;
        Class clazz2=Person.class;
        System.out.println(clazz1==clazz2);
    }

}

class Person{
    String name;
    String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
