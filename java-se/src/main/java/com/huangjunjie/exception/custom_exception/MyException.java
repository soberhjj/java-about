package com.huangjunjie.exception.custom_exception;

/**
 * @author huangJunJie 2021-02-06-22:29
 *          如何自定义异常
 *          1.继承现有的异常结构：RuntimeException(运行时异常) 或 Exception(编译时异常)
 *          2.提供一个serialVersionUID（序列号）
 *          3.提供构造器
 *          就OK了
 */
public class MyException extends Exception{
    private static final long serialVersionUID = 1234567890L;

    public MyException() {
        super();
    }

    public MyException(String s) {
        super(s);
    }
}
