package com.xducs.proxy;


import java.lang.reflect.Proxy;

/**
 * @author Linbo Ge
 * @date 2020/3/18 - 16:43
 */
public class Lenovo implements SaleComputer{
    @Override
    public String sale(double money) {
        System.out.println("花了"+money+"买电脑");
        return "联想电脑";
    }



    @Override
    public void show() {
        System.out.println("展示电脑");
    }
}
