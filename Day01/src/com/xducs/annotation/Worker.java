package com.xducs.annotation;

import java.lang.annotation.Target;

/**
 * @author Linbo Ge
 * @date 2020/2/26 - 18:56
 */
@MyAnno(age = 1, name = "张三", per = Person.P1, anno2 = @MyAnno2, strs = {"fsfa","sjkfks"})
@MyAnno3
public class Worker {
    @MyAnno3
    public String s = "ses";
    @MyAnno3
    public void show(){

    }
}
