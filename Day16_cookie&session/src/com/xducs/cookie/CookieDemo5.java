package com.xducs.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Linbo Ge
 * @date 2020/3/15 - 10:33
 */
@WebServlet("/CookieDemo5")
public class CookieDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*1. 创建Cookie对象，绑定数据
         * new Cookie(String name, String value)
         */
        Cookie cookie = new Cookie("test", "test");
        cookie.setPath("/");
        /*2. 发送Cookie对象
         * response.addCookie(Cookie cookie)*/
        response.addCookie(cookie);
        /*3. 获取Cookie，拿到数据
         * Cookie[]request.getCookies()*/
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
