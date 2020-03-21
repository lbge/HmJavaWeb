package com.xducs.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xducs.domain.User;
import com.xducs.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Linbo Ge
 * @date 2020/3/21 - 15:27
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        //
        UserService service = new UserService();
        User regist = service.regist(username);

        response.setContentType("application/json;charset=utf-8");
        Map<String, Object> map = new HashMap<String, Object>();

        if (regist != null) {
            map.put("userExist", true);
            map.put("msg", "用户名已存在");
        } else {
            map.put("userExist", false);
            map.put("msg", "用户名可用");
        }
        //将数据转换为Json，并发送到客户端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), map);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
