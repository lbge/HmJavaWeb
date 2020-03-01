package com.xducs.reflect;

import com.xducs.domain.Person;

import java.lang.reflect.Field;

/**
 * @author Linbo Ge
 * @date 2020/2/26 - 12:59
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);

            System.out.println("-------------------------");
            Field a = personClass.getField("a");

            Person p = new Person();
            Object value = a.get(p);
            System.out.println(value);
            a.set(p,"aaa");
            System.out.println(p);

            System.out.println("-------------------------");

            Field[] declaredFields = personClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                System.out.println(declaredField);
            }

            System.out.println("-------------------------");

            Field d = personClass.getDeclaredField("d");
            //暴力反射
            d.setAccessible(true);
            Object value2 = d.get(p);
            System.out.println(value2);


        }
    }
}
