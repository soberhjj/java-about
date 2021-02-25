package com.huangjunjie.reflect.ReflectUseCase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author sober 2020-06-05-19:51
 *
 *        需求：写一个框架类，在不改变该类的任何代码的前提下，该类可以帮我们创建任意类的对象，并且可以执行任意方法
 *
 *        实现：1.配置文件
 *             2.反射
 *
 *        步骤：1.将需要创建的对象的全类名和需要执行的方法定义在配置文件中
 *             2.在程序中加载读取配置文件
 *             3.使用反射将类的字节码文件加载进内存
 *             4.创建对象
 *             5.执行方法
 */
public class ReflectUseCase {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        /*
        先来了解下java的Properties类。该类主要用于读取java的配置文件，java的配置文件常为.properties文件，在配置文件中是以键值对的形式进行参数配置的。
        不同的编程语言有自己所支持的配置文件，像Python支持的配置文件是.ini文件，同样它也有自己读取配置文件的类ConfigParse。
        在java中通过Properties类可以方便开发者通过该类中定义的方法来修改.properties配置文件。
        同理在Python中通过ConfigParse类可以方便开发者通过该类中定义的方法来修改.ini文件配置文件。
         */

        //1.加载配置文件
        Properties properties=new Properties();
        properties.load(new FileReader(new File("src\\main\\java\\com\\huangjunjie\\reflect\\ReflectUseCase\\pro.properties")));

        //2.获取配置文件中的数据（根据key获取相应的value）
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        //使用反射将类的字节码文件加载进内存
        Class<?> cls = Class.forName(className);

        //创建对象
        Object obj1 = cls.newInstance();//直接调用class对象的newInstance()方法，那么将以无参构造器创建出给类的一个实例
        Object obj2 = cls.getConstructor(String.class, String.class, String.class).newInstance("张三", "男", "江西赣州");//使用指定构造器创建类的实例


        //执行方法
        Method method = cls.getMethod(methodName);
        method.invoke(obj1);
        method.invoke(obj2);
    }
}
