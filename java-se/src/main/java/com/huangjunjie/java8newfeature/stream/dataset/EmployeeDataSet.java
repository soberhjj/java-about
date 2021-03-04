package com.huangjunjie.java8newfeature.stream.dataset;

import java.util.LinkedList;
import java.util.List;

/**
 * @author huangJunJie 2021-03-04-21:21
 */
public class EmployeeDataSet {

    public static List<Employee> getEmployeeDataSet(){
        LinkedList<Employee> list=new LinkedList<>();
        list.add(new Employee(1,"黄大"));
        list.add(new Employee(2,"黄二"));
        list.add(new Employee(3,"张三"));
        list.add(new Employee(4,"李四"));
        list.add(new Employee(5,"王五"));
        list.add(new Employee(6,"赵六"));
        list.add(new Employee(7,"孙七"));
        return list;
    }
}
