package com.huangjunjie.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author sober 2020-06-04-10:09
 *
 *         测试获取class对象的构造方法
 */
public class GetConstructorTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取Student类的class对象
        Class<Student> studentClass = Student.class;

        //获取所有public修饰的构造器
        Constructor<?>[] constructors = studentClass.getConstructors();
        for (Constructor constructor:constructors)
            System.out.println(constructor);

        System.out.println("----------------");

        //获取所有构造器（无视修饰符级别）
        Constructor<?>[] declaredConstructors = studentClass.getDeclaredConstructors();
        for (Constructor constructor:declaredConstructors)
            System.out.println(constructor);

        System.out.println("----------------");

        //获取指定的public修饰的构造器
        Constructor<Student> constructor = studentClass.getConstructor(String.class, String.class, int.class);
        System.out.println(constructor);

        System.out.println("----------------");

        //获取指定的构造器（无视修饰符级别）
        Constructor<Student> declaredConstructor = studentClass.getDeclaredConstructor(String.class);
        System.out.println(declaredConstructor);

        System.out.println("----------------");

        //利用获取到的private修饰的构造方法创建对象。通常情况下类的私有构造方法只能在类内部用来创建对象，但是在反射面前，这个限制无效
        declaredConstructor.setAccessible(true);//要用私有构造方法对象，加上这个设置既可。
        Student student = declaredConstructor.newInstance("王五");
        System.out.println(student);
    }
}
