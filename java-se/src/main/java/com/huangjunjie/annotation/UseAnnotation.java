package com.huangjunjie.annotation;

/**
 * @author huangJunJie 2021-02-21-14:46
 *
 *    使用自定义的注解
 */
@MyAnnotation(message = "annotation on the class")
public class UseAnnotation {

    @MyAnnotation(message = "annotation on the field" )
    private String name;

    @MyAnnotation(message = "annotation on the method" )
    private void haha(){
        System.out.println("haha");
    }
}
