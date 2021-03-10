package com.huangjunjie.oftenusedclass;

import org.junit.Test;


/**
 * @author huangJunJie 2021-03-10-21:55
 */
public class ComparableDemo {
    @Test
    public void demo() {
        Merchandise merchandise = new Merchandise("KD13", 1314,1111);
        System.out.println(merchandise.compareTo(new Merchandise("Air1", 1010d,2222)));
    }
}

class Merchandise implements Comparable {
    private String name;
    private double price;
    private int id;

    public Merchandise(String name, double price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Merchandise) {
            Merchandise merchandise = (Merchandise) o;
            return Double.compare(price, merchandise.price);
        }
        throw new RuntimeException("传入对象的类型与当前对象的类型不一致，无法比较");
    }
}


