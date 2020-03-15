package com.xducs.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Linbo Ge
 * @date 2020/3/15 - 13:32
 */
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             /*在服务器中的Servlet判断是否有一个名为lastTime的cookie
				1. 有：不是第一次访问
					1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
					2. 写回Cookie：lastTime=2018年6月10日11:50:01
				2. 没有：是第一次访问
					1. 响应数据：您好，欢迎您首次访问
					2. 写回Cookie：lastTime=2018年6月10日11:50:01*/
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)) {
                    flag = true;
                    String value = cookie.getValue();
                    System.out.println("解码前:"+value);
                    String valueDe = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后"+valueDe);
                    response.getWriter().write("<h1>欢迎回来，您上次访问的时间是：" + valueDe + "</h1>");


                    String strDate = sdf.format(date);
                    System.out.println("编码前："+strDate);
                    //URL编码
                    String strDateEn = URLEncoder.encode(strDate, "utf-8");
                    System.out.println("编码后："+strDateEn);
                    cookie.setValue(strDateEn);
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);
                    break;
                }
            }
        }

        if (cookies == null || cookies.length == 0 || !flag) {



            String strDate = sdf.format(date);
            System.out.println("编码前："+strDate);
            //URL编码
            String strDateEn = URLEncoder.encode(strDate, "utf-8");
            System.out.println("编码后："+strDateEn);
            Cookie cookie = new Cookie("lastTime",strDateEn);
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
            response.getWriter().write("<h1>欢迎首次访问 </h1>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
