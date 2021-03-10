package com.huangjunjie.oftenusedclass;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author huangJunJie 2021-03-10-22:40
 */
public class ComparatorDemo {
    @Test
    public void demo() {
        Comparator<Merchandise1> comparator = new Comparator<Merchandise1>() {
            @Override
            public int compare(Merchandise1 o1, Merchandise1 o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        };
        int compare = comparator.compare(new Merchandise1("KD13", 1314, 1111), new Merchandise1("Air1", 1010d, 2222));
        System.out.println(compare);

    }
}

class Merchandise1{
    private String name;
    private double price;
    private int id;

    public Merchandise1(String name, double price, int id) {
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


}
