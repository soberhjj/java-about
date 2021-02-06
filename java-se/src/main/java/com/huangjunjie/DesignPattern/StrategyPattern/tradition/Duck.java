package com.huangjunjie.DesignPattern.StrategyPattern.tradition;

/**
 * @author sober 2020-05-24-15:19
 */
public abstract class Duck {

    public abstract void diaplay(); //显示鸭子信息

    public void jiao(){
        System.out.println("鸭子嘎嘎叫");
    }

    public void swim(){
        System.out.println("鸭子会游泳");
    }

    public void fly(){
        System.out.println("鸭子会飞翔");
    }
}
