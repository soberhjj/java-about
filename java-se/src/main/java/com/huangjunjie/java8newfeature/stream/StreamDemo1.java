package com.huangjunjie.java8newfeature.stream;

import com.huangjunjie.java8newfeature.stream.dataset.Employee;
import com.huangjunjie.java8newfeature.stream.dataset.EmployeeDataSet;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author huangJunJie 2021-03-04-21:03
 * <p>
 * Stream的执行流程
 * 1. 创建Stream（即创建一个数据源）
 * 2. 中间操作（即对数据源执行一系列计算处理的操作链）
 * 3. 终止操作（Stream是懒执行的，只有执行终止操作，2中的一系列中间操作才会真正执行，之后再执行终止操作产生结果数据，这样该Stream整个执行过程就结束了）
 */
//在StreamDemo1中将列举创建Stream的四种方式
public class StreamDemo1 {

    /**
     * 创建Stream。
     * 创建Stream有四种方式
     * 1.通过集合
     * 2.通过数组
     * 3.通过Stream的of方法
     * 4.通过Stream的iterate方法或generate方法创建无限流
     *
     */
    @Test
    public void test1() {
        /**
         * 通过集合创建Stream
         */
        List<Employee> list = EmployeeDataSet.getEmployeeDataSet();
        //如下行，调用Collection接口中stream()方法，返回的是一个顺序流
        //Stream<Employee> stream = list.stream();

        //如下行，调用Collection接口中parallelStream()方法，返回的是一个并行流
        Stream<Employee> employeeStream = list.parallelStream();


    }
    @Test
    public void test2() {
        /**
         * 通过数组创建Stream
         */
        //调用Arrays类的public static <T> Stream<T> stream(T[] array)方法，返回一个流
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        IntStream intStream  = Arrays.stream(a);
    }

    @Test
    public void test3() {
        /**
         * 通过Stream的of方法创建Stream
         */
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7);


    }

    @Test
    public void test4() {
        /**
         * 通过Stream的iterate方法或generate方法创建无限流
         */
        //这是一个无限流，0是初始数据，然后每次在前一个数据值的基础上+2生成一个新的数据
        Stream<Integer> iterate = Stream.iterate(0, t -> t + 2);

        //这也是一个无限流，其中是不断生成的无限个随机数
        Stream<Double> generate = Stream.generate(Math::random);

        //可以通过limit方法来控制获取无限流中指定个数的数据，如下
        Stream<Integer> limitIterate = Stream.iterate(0, t -> t + 2).limit(10);
        Stream<Double> limitGenerate = Stream.generate(Math::random).limit(5);


    }


}
