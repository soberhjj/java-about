package com.huangjunjie.DesignPattern.StrategyPattern.strategy;

/**
 * @author sober 2020-05-24-16:50
 *
 */
public class CanFly implements FlyBehavior {
    public void fly() {
        System.out.println("会飞");
    }
}
