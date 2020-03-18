package com.xducs.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Linbo Ge
 * @date 2020/3/18 - 16:05
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.
        HttpServletRequest request = (HttpServletRequest) req;
        String requestURI = request.getRequestURI();
        if (requestURI.contains("/login.jsp") || requestURI.contains("/LoginServlet")||requestURI.contains("/css/")||requestURI.contains("/js/")||requestURI.contains("/fonts/")||requestURI.contains("/CheckCodeServlet")){
            chain.doFilter(req, resp);
        }else {
            Object admin = request.getSession().getAttribute("admin");
            if (admin != null){
                chain.doFilter(req, resp);
            }else {
                request.setAttribute("login_msg","请登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
