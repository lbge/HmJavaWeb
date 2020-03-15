package com.xducs.servlet;

import com.xducs.bean.User;
import com.xducs.dao.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Linbo Ge
 * @date 2020/3/15 - 16:33
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static UserDao dao = new UserDao();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");


        String checkCode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        String checkCode1 = (String) session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        if (checkCode1 != null &&checkCode1.equalsIgnoreCase(checkCode)) {
            Map<String, String[]> parameterMap = request.getParameterMap();
            User loginUser = new User();
            try {
                BeanUtils.populate(loginUser,parameterMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            User user = dao.login(loginUser);
            if (user != null) {
                String username = user.getUsername();
                session.setAttribute("username", username);
               response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else {
                request.setAttribute("loginFail", "用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("checkCodeErr", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
