package com.huangjunjie.DesignPattern.proxypattern.dynamicproxy;

/**
 * @author huangJunJie 2021-02-24-20:33
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 接口
 */
interface Human {
    String belief();

    void eat(String food);
}

/**
 * 被代理类
 */
class SuperMan implements Human {

    @Override
    public String belief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("I like eat " + food);
    }
}

/**
 * 动态代理就是根据加载到内存中的被代理类，动态的创建一个代理类及该代理类对象
 * 要想实现动态代理，需要解决的问题？
 * 问题一：如何动态创建代理类及其对象？
 * 问题二：当调用代理类对象的方法时，如何动态的去调用被代理类对象中的同名方法？
 */

/**
 * 写一个专门生产代理类的工厂
 */
class ProxyFactory {
    /**
     * @param obj obj就是被代理类的对象
     * @return getProxyInstance方法就是去构建一个传入的被代理类对象的代理类对象
     *      通过getProxyInstance方法可构建任何类的对象的代理类对象
     */
    public static Object getProxyInstance(Object obj) {

        //通过java.lang.reflect包中的Proxy类的newProxyInstance方法就可以去创建一个代理类对象
        /**
         * newProxyInstance方法的参数说明：
         * 参数1：ClassLoader loader 即传入类加载器，一般就是直接传入被代理类的类加载器
         * 参数2：Class<?>[] interfaces 传入被代理类实现的所有接口
         * 参数3：InvocationHandler h 传入一个调用Handler
         *
         * 参数1和参数2 用于实现上述的问题一（即动态创建代理类及其对象）
         * 参数3 用于实现上述的问题二（即动态的去调用被代理类对象中的同名方法）
         */
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(obj);
        Object proxyObj = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), myInvocationHandler);

        return proxyObj;
    }
}

class MyInvocationHandler implements InvocationHandler {

    //定义一个对象，该对象就是被代理类的对象
    private Object obj;

    //给上面的obj赋值，即绑定被代理类对象
    public void bind(Object obj) {
        this.obj = obj;
    }


    /**
     * invoke方法：当我们调用代理类的任何方法时，都会自动的去执行这个invoke方法。
     *
     * @param proxy  代理类对象
     * @param method 调用的代理类对象的方法
     * @param args   调用的代理类对象的方法的参数
     * @return invoke方法的返回值就是调用的代理类对象的方法的返回值，即参数method方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过method.invoke()去调用被代理类对象中的method方法，同时调用时方法的参数和代理类对象中的该方法被调用时的参数保持一致
        Object returnValue = method.invoke(obj, args);
        return returnValue;
    }
}

public class DynamicProxyDemo {

    public static void main(String[] args) {
        //被代理对象
        SuperMan superMan = new SuperMan();
        //获取被代理类对象（即SuperMan对象）的一个代理类对象（即下面的proxyInstance）
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //下面我们去调用代理类对象即proxyInstance的belief方法和eat方法，那么实际上它是去调用被代理对象即SuperMan对象中的belief方法和eat方法。
        String belief = proxyInstance.belief();
        System.out.println(belief);
        proxyInstance.eat("麻辣烫");

    }
}

//上述这个demo确实是动态代理demo，但是通过这个demo看不出动态代理的好处在哪。
//说明：在main方法中创建了一个SuperMan对象，然后又去获取了该对象的一个代理对象，最后通过代理对象去实际调用SuperMan对象的方法。
//那干嘛不直接去调用SuperMan对象的方法，这里造个代理对象没啥作用呀。

//在静态代理的demo中我们可以看到代理的好处，好处就是通过代理对象可以实现在实际调用被代理对象的方法的之前和之后做一些工作。
//那么在这个动态代理demo中并没有看到这种好处。确实如此，对于这个demo，实际上想通过这个demo大概的了解下动态代理是怎么实现的。

//接下来在DynamicProxyAndAopDemo(动态代理与AOP)中来领略动态代理的好处。
//DynamicProxyAndAopDemo的代码是基于DynamicProxyDemo的代码增加了一点东西来实现AOP，从而体现动态代理的好处
