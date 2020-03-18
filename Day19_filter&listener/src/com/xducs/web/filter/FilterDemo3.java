package com.xducs.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Linbo Ge
 * @date 2020/3/18 - 13:51
 */
//@WebFilter("/*")
public class FilterDemo3 implements Filter {

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter...");
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

}
