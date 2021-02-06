package com.huangjunjie.reflect;

import java.lang.reflect.Field;

/**
 * @author sober 2020-06-03-22:31
 *
 *       测试获取class对象的成员变量
 */
public class GetFieldTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        //获取Student类的class对象
        Class<Student> studentClass = Student.class;

        //获取class对象中所有public修饰的成员变量
        Field[] fields = studentClass.getFields();
        for (Field field:fields)
            System.out.println(field);

        System.out.println("------------");

        //获取class对象中指定的public修饰的成员变量
        Field address = studentClass.getField("address");
        Student student=new Student("computer","张三",4);
        address.set(student,"福建");//设置指定对象的该Field的值，这里就是设置student对象中的成员变量address的值为“福建”
        System.out.println(address.get(student));//获取指定对象的该Field的值，这里就是获取student对象中的成员变量address的值

        System.out.println("------------");

        //获取class对象中所有的成员变量（无视修饰符级别）
        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field field:declaredFields)
            System.out.println(field);

        //获取class对象中指定的成员变量（无视修饰符级别），这里获取一个私有的成员变量name
        Field name = studentClass.getDeclaredField("name");
        System.out.println(name);

        //设置对象中私有成员变量的值。在以前我们知道对象的私有成员变量不能在外部被直接访问（获取值或赋值），但在反射面前，没有什么私有和公有，全都可以直接操作
        name.setAccessible(true);//对私有成员变量进行操作，加上这个设置既可。它可以忽略访问权限修饰符的安全检查
        name.set(student,"李四");
        System.out.println(name.get(student));


    }
}
