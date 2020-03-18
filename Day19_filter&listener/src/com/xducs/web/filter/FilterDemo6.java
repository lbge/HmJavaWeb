package com.xducs.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Linbo Ge
 * @date 2020/3/18 - 15:50
 */
@WebFilter("/*")
public class FilterDemo6 implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo6执行了。。。");
        chain.doFilter(req, resp);
        System.out.println("filterDemo6回来了。。。");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
