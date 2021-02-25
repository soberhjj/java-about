package com.huangjunjie.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author huangJunJie 2021-02-21-14:45
 *
 *      定义一个注解
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String message() default "hello";
}
