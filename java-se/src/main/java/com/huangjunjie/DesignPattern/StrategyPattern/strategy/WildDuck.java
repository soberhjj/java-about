package com.huangjunjie.DesignPattern.StrategyPattern.strategy;

/**
 * @author sober 2020-05-24-16:56
 */
public class WildDuck extends Duck {

    //初始化父类（即抽象类Duck）中定义的策略接口属性
    public WildDuck(){
        flyBehavior=new CanFly();
        swimBehavior=new CanSwim();
    }

    @Override
    public void diaplay() {
        System.out.println("这是一只野鸭");
        jiao();
        fly();
        swim();
    }
}
