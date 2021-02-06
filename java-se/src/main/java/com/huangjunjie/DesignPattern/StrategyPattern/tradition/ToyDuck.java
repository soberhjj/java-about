package com.huangjunjie.DesignPattern.StrategyPattern.tradition;

/**
 * @author sober 2020-05-24-15:32
 */
public class ToyDuck extends Duck {

    @Override
    public void diaplay() {
        System.out.println("这是一只玩具鸭");
    }

    //玩具鸭会叫，但是不会游泳也不会飞，所以要重写swim()方法和fly()方法
    @Override
    public void swim() {
        System.out.println("玩具鸭不会游泳");
    }

    @Override
    public void fly() {
        System.out.println("玩具鸭不会飞");
    }
}
