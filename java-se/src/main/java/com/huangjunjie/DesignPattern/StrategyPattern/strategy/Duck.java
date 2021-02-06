package com.huangjunjie.DesignPattern.StrategyPattern.strategy;

/**
 * @author sober 2020-05-24-15:19
 */
public abstract class Duck {

    //以策略接口作为属性
    FlyBehavior flyBehavior;
    SwimBehavior swimBehavior;

    public abstract void diaplay(); //显示鸭子信息

    public void jiao(){    //我们假设所有的鸭子都会嘎嘎叫，所以不需要“嘎嘎叫行为”的策略接口，因为无需策略，对于“嘎嘎叫行为”所有的鸭子都是一样的。
        System.out.println("会嘎嘎叫");
    }

    public void swim(){
        if (swimBehavior!=null){
            swimBehavior.swim();
        }
    }

    public void fly(){
        if (flyBehavior!=null){
            flyBehavior.fly();
        }
    }

    //getter and setter
    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public SwimBehavior getSwimBehavior() {
        return swimBehavior;
    }

    public void setSwimBehavior(SwimBehavior swimBehavior) {
        this.swimBehavior = swimBehavior;
    }


}
