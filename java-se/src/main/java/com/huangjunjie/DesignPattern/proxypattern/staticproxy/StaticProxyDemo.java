package com.huangjunjie.DesignPattern.proxypattern.staticproxy;

/**
 * @author huangJunJie 2021-02-23-21:28
 * 静态代理demo
 */


/**
 * 首先写一个衣服工厂的接口。接口中定义了一个生产衣服方法。代理类和被代理类都去实现这个接口。
 */
interface ClothFactory {
    void produceCloth();
}

/**
 * 代理类 ProxyClothFactory
 */
class ProxyClothFactory implements ClothFactory {

    //factory是被代理对象的引用
    private ClothFactory factory;

    //在代理类的构造器初始化被代理对象
    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }


    @Override
    public void produceCloth() {
        System.out.println("代理对象做的一些准备工作");

        //调用被代理对象的produceCloth方法
        factory.produceCloth();

        System.out.println("代理对象做的一些后续工作");

    }
}

/**
 * 被代理类 NikeClothFactory
 */
class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("耐克工厂生产一批球鞋");
    }
}


class StaticProxyTest {
    public static void main(String[] args) {
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(new NikeClothFactory());
        proxyClothFactory.produceCloth();
    }
}
