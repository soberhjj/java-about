package com.huangjunjie.reflect;


import java.util.Random;

/**
 * @author huangJunJie 2021-02-23-19:06
 * <p>
 * 通过该demo体会下反射带来的动态性。
 */
public class NewinstanceTest {


    public static void main(String[] args) throws Exception {
        int i = new Random().nextInt(2);
        String classPath;
        switch (i) {
            case 0:
                classPath="java.util.Date";
                break;
            case 1:
                classPath="java.util.ArrayList";
                break;
            default:
                classPath="";
        }

        //在编译期是无法确定obj这个对象是哪个类的实例，只能在程序运行期间根据随机整数i的取值来确定它是哪个类的实例，这也正是体现了反射的动态性
        Object obj = getInstance(classPath);
        System.out.println(obj);

    }


    /**
     * 通过一个全类名路径来生成类实例
     *
     * @param classPath
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(classPath);
        Object obj = clazz.newInstance();
        return obj;


    }


}
