package com.huangjunjie.oftenusedclass;

import org.junit.Test;

/**
 * @author huangJunJie 2021-03-08-21:59
 *
 *      列举StringBuffer、StringBuilder的常用方法
 *
 */
public class StringBufferAndStringBuilderDemo {
    @Test
    public void stringBufferDemo(){
        StringBuffer sb=new StringBuffer();
        //StringBuffer提供了很多append()方法，用于进行字符串的拼接
        sb.append("hello,");
        sb.append("china!");
        //删除指定位置的内容
        sb.delete(0,1);
        //替换指定位置的内容
        sb.replace(5,10,"world");
        //在指定位置插入
        sb.insert(0,"hell0 hi");
        //把当前字符序列逆转
        sb.reverse();
        //指定字符串在当前字符串中首次出现的位置
        sb.indexOf("china");
        //截取
        sb.substring(0,5);
        //字符序列长度
        sb.length();
        //改变指定位置的字符
        sb.setCharAt(1,'h');
        //返回指定位置的字符
        sb.charAt(5);
    }
    @Test
    public void stringBuilderDemo(){
        //StringBuilder的方法和StringBuffer的方法一样，不写了
    }
}
