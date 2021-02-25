package com.huangjunjie.reflect;

/**
 * @author sober 2020-06-03-18:16
 * <p>
 * 获取Class对象的四种方式：
 * 1、Class.forName("全类名")：将字节码文件加载进内存，返回该字节码文件对应的Class对象
 * 2、类名.class：通过类属性class获取
 * 3、对象.getClass()：getClass()方法在Object类中定义
 * 4. 通过类加载器显示的去加载一个类，加载后就会返回这个类的Class对象
 */
public class GetClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        //以Class.forName("全类名")方式获取Class对象
        Class<?> cls1 = Class.forName("com.huangjunjie.reflect.Student");
        System.out.println(cls1);

        //以类名.class方式获取Class对象
        Class<Student> cls2 = Student.class;
        System.out.println(cls2);

        //以对象.getClass()方式获取Class对象
        Class<? extends Student> cls3 = new Student("computer", "sober", 4).getClass();
        System.out.println(cls3);

        //通过类加载器显示的去加载一个类
        ClassLoader classLoader = GetClassTest.class.getClassLoader();
        Class cls4 = classLoader.loadClass("com.huangjunjie.reflect.Student");
        System.out.println(cls4);

        System.out.println(cls1 == cls2);
        System.out.println(cls2 == cls3);
        System.out.println(cls3 == cls4);
        //cls1==cls2返回ture,cls2==cls3返回ture,cls3==cls4返回ture,所以cls1==cls2==cls3==cls4。
        //结论：同一字节码文件在一次程序运行过程中只会被加载一次，不论通过哪种方式获得的class对象都是同一个。


    }
}

