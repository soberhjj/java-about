package com.huangjunjie.enumclass;

import org.junit.Test;

/**
 * @author huangJunJie 2021-02-19-23:06
 */
public class Main {

    @Test
    public void testEnumObject() {
        Season spring = Season.SPRING;
        System.out.println(spring.getSeasonName());
    }

    /**
     * 测试使用Enum类中的常用方法。使用enum关键字定义的枚举类其父类为java.lang.Enum类，所以直接用Season这个枚举类来测试使用Enum类中的常用方法。
     */
    @Test
    public void testEnumMethod() {
        //常用方法1：values() 返回枚举类的所有对象
        Season[] seasons = Season.values();
        for (Season season : seasons) {
            System.out.println(season.getSeasonName());
        }
        System.out.println("--------------------");

        //常用方法2: valueOf(String str) 返回枚举类的指定名称的枚举对象
        Season season = Season.valueOf("SPRING");
        System.out.println(season.getSeasonName());
        System.out.println("--------------------");

        //常用方法3：toString() 返回当前枚举对象的对象名称
        Season[] seasonss = Season.values();
        for (Season temp : seasonss) {
            System.out.println(temp.toString());
        }
    }

    @Test
    public void testEnumImplInfo1() {
        SeasonImplInfo1 autumn = SeasonImplInfo1.AUTUMN;
        autumn.show();

        SeasonImplInfo1 winter = SeasonImplInfo1.WINTER;
        winter.show();
    }

    @Test
    public void testEnumImplInfo2() {
        SeasonImplInfo2 autumn = SeasonImplInfo2.AUTUMN;
        autumn.show();

        SeasonImplInfo2 winter = SeasonImplInfo2.WINTER;
        winter.show();
    }
}
