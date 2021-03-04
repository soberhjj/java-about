package com.huangjunjie.java8newfeature.lambda;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author huangJunJie 2021-02-28-21:36
 * <p>
 * 使用Lambda表达式替代匿名内部类demo
 */
public class LambdaDemo {

    /**
     * demo1:实现Runnable接口是匿名内部类的经典例子，下面就分别用匿名内部类方式和Lambda方式来实现Runnable接口，看下Lambda是多么简洁
     */
    @Test
    public void demo1() {
        //匿名内部类方式
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("I love china");
            }
        };
        r1.run();

        System.out.println("=====================");

        //Lambda方式
        Runnable r2 = () -> {
            System.out.println("I love china");
        }; //这对大括号可以省略,因为这个代码块中只有一个语句，当有多个语句时不能省略。
        r2.run();
    }

    /**
     * demo2:分别用匿名内部类方式和Lambda方式来实现接口，看下Lambda是多么简洁
     */
    @Test
    public void demo2() {
        //匿名内部类方式
        Comparator<Integer> c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(c1.compare(1, 2));

        System.out.println("=====================");

        //Lambda方式
        Comparator<Integer> c2 = (o1, o2) -> {
            return Integer.compare(o1, o2);
        };//当代码块中只有一个语句，且代码块需要return(即有返回值)时，这个大括号和语句中的return可同时省略

        System.out.println(c2.compare(1, 2));
    }


}
