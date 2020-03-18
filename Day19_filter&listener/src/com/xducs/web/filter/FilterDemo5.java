package com.xducs.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Linbo Ge
 * @date 2020/3/18 - 15:15
 */
//@WebFilter(value ="/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
//@WebFilter(value ="/index.jsp",dispatcherTypes = DispatcherType.FORWARD)
//@WebFilter(value ="/index.jsp",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})

public class FilterDemo5 implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo5");
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
