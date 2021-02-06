package com.huangjunjie.DesignPattern.StrategyPattern.strategy;

/**
 * @author sober 2020-05-24-17:05
 */
public class ToyDuck extends Duck {

    public ToyDuck(){
        flyBehavior=new NoFly();
        swimBehavior=new NoSwin();
    }

    @Override
    public void diaplay() {
        System.out.println("这是一只玩具鸭");
        jiao();
        fly();
        swim();

    }
}
