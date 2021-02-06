package com.huangjunjie.DesignPattern.StrategyPattern.strategy;

/**
 * @author sober 2020-05-24-17:02
 */
public class HomeDuck extends Duck {

    public  HomeDuck(){
        flyBehavior=new NoFly();
        swimBehavior=new CanSwim();
    }

    @Override
    public void diaplay() {
        System.out.println("这是一只家鸭");
        jiao();
        fly();
        swim();
    }
}
