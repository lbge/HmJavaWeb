package com.xducs.annotation;

/**
 * @author Linbo Ge
 * @date 2020/2/26 - 18:09
 */
public @interface MyAnno {

    int age();//public abstract 可以省略
    String name() default "张三";
    Person per();
    MyAnno2 anno2();
    String[] strs();

/*    String show();





  */
}
