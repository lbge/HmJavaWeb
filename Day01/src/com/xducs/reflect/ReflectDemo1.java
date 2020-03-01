package com.xducs.reflect;

import com.xducs.domain.Person;

/**
 * @author Linbo Ge
 * @date 2020/2/26 - 16:40
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws Exception {
        Class cls1 = Class.forName("com.xducs.domain.Person");
        System.out.println(cls1);

        Class cls2 = Person.class;
        System.out.println(cls2);
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);

        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);

    }
}
