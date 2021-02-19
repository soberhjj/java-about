package com.huangjunjie.enumclass;


/**
 * @author huangJunJie 2021-02-19-22:57
 */
enum SeasonImplInfo1 implements Info {

    //1.提供当前枚举类的所有对象，注意多个对象之间用逗号“,”隔开，最后一个对象用封号“;”
    SPRING("春天"),
    SUMMER("夏天"),
    AUTUMN("秋天"),
    WINTER("冬天");

    //2.声明Season对象的属性：需要用private final修饰
    private final String seasonName;

    //3.私有化类的构造器
    private SeasonImplInfo1(String seasonName){
        this.seasonName=seasonName;
    }

    //4.其他诉求：如获取枚举类对象的属性
    public String getSeasonName(){
        return seasonName;
    }


    //可以直接在枚举类中实现接口中的方法，这样相当于所有的枚举对象都实现了接口中的方法，且方法逻辑一样，如下
    public void show() {
        System.out.println("这是一个季节");
    }

    //也可以各个枚举对象自己去实现接口中的方法，见SeasonImplInfo1
}


