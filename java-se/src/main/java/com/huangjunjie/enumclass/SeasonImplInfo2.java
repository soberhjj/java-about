package com.huangjunjie.enumclass;


/**
 * @author huangJunJie 2021-02-19-22:57
 */
enum SeasonImplInfo2 implements Info {

    //1.提供当前枚举类的所有对象，注意多个对象之间用逗号“,”隔开，最后一个对象用封号“;”
    //各个枚举对象自己去实现接口中的方法（这种方式本质就是通过匿名内部类的形式实现接口）
    SPRING("春天"){
        public void show() {
            System.out.println("春天很温暖");
        }
    },
    SUMMER("夏天"){
        public void show() {
            System.out.println("春天很激情");
        }
    },
    AUTUMN("秋天"){
        public void show() {
            System.out.println("秋天很惬意");
        }
    },
    WINTER("冬天"){
        public void show() {
            System.out.println("冬天很洁白");
        }
    };

    //2.声明Season对象的属性：需要用private final修饰
    private final String seasonName;

    //3.私有化类的构造器
    private SeasonImplInfo2(String seasonName){
        this.seasonName=seasonName;
    }

    //4.其他诉求：如获取枚举类对象的属性
    public String getSeasonName(){
        return seasonName;
    }


}


