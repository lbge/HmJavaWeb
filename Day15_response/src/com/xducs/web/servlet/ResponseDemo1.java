package com.xducs.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 * @author Linbo Ge
 * @date 2020/3/14 - 10:41
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo1....");
        /*//访问responseDemo1自动跳转到responseDemo2
        response.setStatus(302);
        response.setHeader("location","/Day15/responseDemo2");*/
        response.sendRedirect("/Day15/responseDemo2");
//        response.sendRedirect("https://www.baidu.com");
        request.setAttribute("msg","response");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
