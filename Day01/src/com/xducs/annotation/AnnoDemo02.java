package com.xducs.annotation;

import java.util.Date;

/**
 * @author Linbo Ge
 * @date 2020/2/26 - 17:56
 */
@SuppressWarnings("all")
public class AnnoDemo02 {

    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1(){

    }
    public void show2(){

    }

    public void demo(){
        show1();
        Date date = new Date();
    }
}
