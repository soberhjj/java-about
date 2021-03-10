package com.huangjunjie.oftenusedclass;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author huangJunJie 2021-03-07-11:15
 * 常用类之 String类
 */
public class StringDemo {
    @Test
    public void demo1() {
        String s = "Hello China! hello you!  ";
        //int length()：返回字符串的长度
        int length = s.length();
        //char charAt(int index)：返回指定索引处的字符
        char c = s.charAt(2);
        //boolean isEmpty()：判断是否是空字符串
        boolean empty = s.isEmpty();
        //使用默认语言环境，将String中的所有字符转换为小写
        String s1 = s.toLowerCase();
        //使用默认语言环境，将String中的所有字符转换为大写
        String s2 = s.toUpperCase();
        //返回字符串副本，忽略字符串前后空白
        String trim = s.trim();
        //比较字符串的内容是否相同
        boolean equals = s.equals("hello china! hello you!  ");
        //比较字符串的内容是否相同，忽略大小写
        boolean b = s.equalsIgnoreCase("hello china! hello you!  ");
        //将指定字符串连接到此字符串的结尾。等价于用"+"
        String concat = s.concat("hello me!");
        //比较两个字符串的大小
        int i = s.compareTo("hello china! hello you!  ");

        //从字符串中截取子串
        String substring = s.substring(1, 7);

        //判断字符串是否以指定前缀开始
        boolean b1 = s.startsWith("Helo");
        //判断字符串从指定索引开始的子字符串是否以指定前缀开始
        boolean b2 = s.startsWith("elo", 1);
        //判断字符串是否以指定后缀结束
        boolean b3 = s.endsWith("you!  ");

        //boolean contains(CharSequence s)：当前仅当此字符串中包含指定的字符序列时返回true
        boolean b4 = s.contains("China");

        //返回指定子字符串在此字符串中第一次出现处的索引
        int hello = s.indexOf("hello");
        //返回指定子字符串在此字符串中最右边出现处的索引
        int hello1 = s.lastIndexOf("hello");

        //String replace(char oldChar, char newChar)：用指定的新字符替换字符串中指定的老字符
        String replace = s.replace('h', 'y');
        //String replace(CharSequence target, CharSequence replacement):用指定的字符序列替换字符串中指定的字符序列
        String replace1 = s.replace("hello", "hi");

        //String replaceAll(String regex, String replacement):使用给定的replacement替换此字符串中所有匹配给定的正则表达式的子字符串
        String s3 = s.replaceAll("you", "me");

        //判断字符串是否匹配给定的正则表达式
        boolean matches = s.matches("hello china! hello you!  ");

        //根据给定的正则表达式拆分此字符串
        String[] split = s.split("!");

        //获取此字符串的字符数组
        char[] chars = s.toCharArray();

        //获取此字符串的字节数组
        byte[] bytes = s.getBytes();
    }


    //String格式化
    @Test
    public void demo2(){

    }


}
