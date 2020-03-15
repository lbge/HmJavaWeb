package com.xducs.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Linbo Ge
 * @date 2020/3/14 - 14:45
 */
@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*1. 通过request对象获取
        request.getServletContext();*/
        ServletContext context = request.getServletContext();
      /*  2. 通过HttpServlet获取
        this.getServletContext();*/
        ServletContext context1 = this.getServletContext();
        System.out.println(context);
        System.out.println(context1);

        System.out.println(context == context1);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
