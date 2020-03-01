package com.xducs.reflect;

import com.xducs.domain.Person;

import java.lang.reflect.Constructor;

/**
 * @author Linbo Ge
 * @date 2020/2/26 - 12:59
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);

        Object person = constructor.newInstance("张三", 25);
        System.out.println(person);

        System.out.println("---------------------");

        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1);

        Object person1 = constructor1.newInstance();
        System.out.println(person1);

        Object o = personClass.newInstance();
        System.out.println(o);
    }
}
