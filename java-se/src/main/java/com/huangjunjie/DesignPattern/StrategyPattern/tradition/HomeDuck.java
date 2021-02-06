package com.huangjunjie.DesignPattern.StrategyPattern.tradition;

/**
 * @author sober 2020-05-24-15:25
 */
public class HomeDuck extends Duck {
    @Override
    public void diaplay() {
        System.out.println("这是一只家鸭");
    }

    //因为家鸭会叫、会游泳，但是不能飞，所以要重写fly()方法

    @Override
    public void fly() {
        System.out.println("家鸭不会飞");
    }
}
