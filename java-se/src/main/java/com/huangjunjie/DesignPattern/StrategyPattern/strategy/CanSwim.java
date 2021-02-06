package com.huangjunjie.DesignPattern.StrategyPattern.strategy;

/**
 * @author sober 2020-05-24-17:03
 */
public class CanSwim implements SwimBehavior {
    public void swim() {
        System.out.println("会游泳");
    }
}
