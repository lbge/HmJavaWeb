package com.xducs.reflect;

import com.xducs.domain.Person;

import java.lang.reflect.Method;

/**
 * @author Linbo Ge
 * @date 2020/2/26 - 12:59
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        Method eat_method = personClass.getMethod("eat");
        Person p = new Person();
        eat_method.invoke(p);

        Method eat_method2 = personClass.getMethod("eat", String.class);
        eat_method2.invoke(p,"fan");

        System.out.println("-----------------");
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
        }

        String name = personClass.getName();
        System.out.println(name);
    }
}
