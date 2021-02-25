package com.huangjunjie.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author huangJunJie 2021-02-21-16:50
 *
 *      解析处理注解
 */
public class ProcessingAnnotation{
    public static void main(String[] args) throws Exception {
        Class<UseAnnotation> clazz = UseAnnotation.class;
        //获取类上的注解
        MyAnnotation annotationOnClass = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnClass.message());


        //获取成员变量上的注解
        Field field = clazz.getDeclaredField("name");
        MyAnnotation annotationOnFiled = field.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnFiled.message());

        //获取成员方法上的注解
        Method method = clazz.getDeclaredMethod("haha", null);
        MyAnnotation annotationOnMethod = method.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnMethod.message());
    }
}
