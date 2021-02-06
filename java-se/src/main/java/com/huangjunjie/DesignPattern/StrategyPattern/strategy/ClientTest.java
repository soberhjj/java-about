package com.huangjunjie.DesignPattern.StrategyPattern.strategy;

/**
 * @author sober 2020-05-24-17:15
 */
public class ClientTest {
    public static void main(String[] args) {
        new WildDuck().diaplay();
        System.out.println("-----------------");

        new HomeDuck().diaplay();
        System.out.println("-----------------");

        new ToyDuck().diaplay();
        System.out.println("-----------------");

        //创建一只野鸭，并将其行为改变为不会飞，不会游泳
        WildDuck wile=new WildDuck();
        wile.setFlyBehavior(new NoFly());
        wile.setSwimBehavior(new NoSwin());
        wile.diaplay();
    }
}
