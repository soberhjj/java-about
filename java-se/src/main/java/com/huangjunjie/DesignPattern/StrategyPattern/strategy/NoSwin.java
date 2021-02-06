package com.huangjunjie.DesignPattern.StrategyPattern.strategy;

/**
 * @author sober 2020-05-24-17:04
 */
public class NoSwin implements SwimBehavior {
    public void swim() {
        System.out.println("不会游泳");
    }
}
