package com.xducs.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet方法
 * @author Linbo Ge
 * @date 2020/3/10 - 16:48
 */
public class ServletDemo2 implements Servlet {
    /**
     * 初始化方法
     * 在Servlet被创建时执行，只会执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init......");
    }

    /**
     * 获取Servl配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法，会执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service.....");
    }

    /**
     * 获取servlet的一些信息，比如版本...
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务器正常关闭时执行，执行一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy.....");
    }
}
