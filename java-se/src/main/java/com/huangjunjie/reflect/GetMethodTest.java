package com.huangjunjie.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author sober 2020-06-04-10:48
 *      测试获取class对象的成员方法
 */
public class GetMethodTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //获取Student类的class对象
        Class<Student> studentClass = Student.class;

        //获取class对象中的所有public修饰的成员方法
        Method[] methods = studentClass.getMethods();
        for (Method method:methods)
            System.out.println(method);

        System.out.println("---------------");

        //获取class对象中的所有成员方法(无视修饰符级别)
        Method method = studentClass.getMethod("setCollege",String.class);
        System.out.println(method);

        System.out.println("---------------");

        //获取class对象中的所有成员方法(无视修饰符级别)
        Method[] declaredMethods = studentClass.getDeclaredMethods();
        for (Method m:declaredMethods)
            System.out.println(m);

        System.out.println("---------------");

        //获取class对象中的指定的成员方法(无视修饰符级别),下面获取一个private修饰的成员方法
        Method method1 = studentClass.getDeclaredMethod("sayHello");
        System.out.println(method1);

        System.out.println("---------------");

        //调用指定对象的某方法（该方法是public修饰的方法）
        Student student=new Student("computer","张三",4);
        Method m1 = studentClass.getMethod("sayHi");
        m1.invoke(student);

        System.out.println("---------------");

        //调用指定对象的某方法（该方法是private修饰的方法）
        Method m2 = studentClass.getDeclaredMethod("sayHello");
        m2.setAccessible(true);//忽略访问权限修饰符的安全检查
        m2.invoke(student);




    }
}
