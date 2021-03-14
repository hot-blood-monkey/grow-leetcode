package com.example.demo.Java.Aspect.annotation;

import java.lang.annotation.*;

/**
 * @author zh
 * @date 2021-03-10 10:58
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Facade {
}
