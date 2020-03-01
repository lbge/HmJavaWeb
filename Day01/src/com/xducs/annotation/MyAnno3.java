package com.xducs.annotation;

import java.lang.annotation.*;

/**
 * @author Linbo Ge
 * @date 2020/2/26 - 20:43
 */

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})//取值是数组，故采用大括号
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnno3 {

}
