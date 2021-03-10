package com.huangjunjie.java8newfeature.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author huangJunJie 2021-03-07-10:06
 */
public class OptionalDemo {

    @Test
    public void test1() {
        //创建一个包含Employee实例的Optional实例
        Optional<Employee> optionalEmployee1 = Optional.ofNullable(new Employee(1, "张三"));

        //创建一个包含空对象的Optional实例
        Employee employee = null;
        Optional<Employee> optionalEmployee2 = Optional.ofNullable(employee);

        //如果很明确Optional中的对象不为null，那么可以直接通过get方法去取对象。
        System.out.println(optionalEmployee1.get().getName());
        //注意如果对象是null的话，用get取的话会抛异常。如下这行代码就会抛异常，因为optionalEmployee2中的Employee对象为null
//        System.out.println(optionalEmployee2.get().getName());

        //如果不确定Optional中的对象是否为null，可以通过 T orElse(T other)方法来取对象，如果对象不为null则将其返回，如果对象为null则返回指定的other对象
        Employee employee1 = optionalEmployee2.orElse(new Employee(2, "李四"));
        System.out.println(employee1.getName());

    }
}
