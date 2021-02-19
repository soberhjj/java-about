package com.huangjunjie.enumclass;


/**
 * @author huangJunJie 2021-02-19-22:57
 */
enum Season {

    //1.提供当前枚举类的所有对象，注意多个对象之间用逗号“,”隔开，最后一个对象用封号“;”
    SPRING("春天"),
    SUMMER("夏天"),
    AUTUMN("秋天"),
    WINTER("冬天");

    //2.声明Season对象的属性：需要用private final修饰
    private final String seasonName;

    //3.私有化类的构造器
    private Season(String seasonName){
        this.seasonName=seasonName;
    }

    //4.其他诉求：如获取枚举类对象的属性
    public String getSeasonName(){
        return seasonName;
    }
}


