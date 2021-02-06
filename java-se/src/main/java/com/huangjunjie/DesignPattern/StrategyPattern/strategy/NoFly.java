package com.huangjunjie.DesignPattern.StrategyPattern.strategy;

/**
 * @author sober 2020-05-24-16:50
 */
public class NoFly implements FlyBehavior{
    public void fly() {
        System.out.println("不会飞");
    }
}
