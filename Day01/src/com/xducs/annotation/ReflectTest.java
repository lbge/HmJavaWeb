package com.xducs.annotation;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Linbo Ge
 * @date 2020/2/26 - 16:11
 */
@pro(className = "com.xducs.annotation.Demo02",methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        pro an = reflectTestClass.getAnnotation(pro.class);
        String className = an.className();
        String methodName = an.methodName();


        //3.加载该类进内存
        Class cls = Class.forName(className);
        //4.创建对象
        Object obj = cls.newInstance();
        //5.获取方法对象
        Method method = cls.getMethod(methodName);
        //6.执行方法
        method.invoke(obj);

    }
}
