package com.huangjunjie.java8newfeature.stream.dataset;

/**
 * @author huangJunJie 2021-03-04-21:19
 */

public class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
