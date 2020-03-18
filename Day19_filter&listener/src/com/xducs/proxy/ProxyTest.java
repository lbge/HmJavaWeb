package com.xducs.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Linbo Ge
 * @date 2020/3/18 - 16:45
 */
public class ProxyTest {
    public static void main(String[] args) {
        Lenovo lenovo = new Lenovo();

        //动态代理
        //2.动态代理增强lenovo对象
        /*
            三个参数：
                1. 类加载器：真实对象.getClass().getClassLoader()
                2. 接口数组：真实对象.getClass().getInterfaces()
                3. 处理器：new InvocationHandler()
         */
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /*
                代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
                    参数：
                        1. proxy:代理对象
                        2. method：代理对象调用的方法，被封装为的对象
                        3. args:代理对象调用的方法时，传递的实际参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               /* System.out.println("该方法执行了");
                System.out.println(method.getName());
                System.out.println(args[0]);*/

               //使用真实对象调用方法
                Object obj = method.invoke(lenovo, args);

                return obj;
            }
        });

        String computer = proxy_lenovo.sale(8000);
        System.out.println(computer);
    }
}
