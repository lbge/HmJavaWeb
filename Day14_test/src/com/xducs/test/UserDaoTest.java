package com.xducs.test;

import com.xducs.dao.UserDao;
import com.xducs.domain.User;
import org.junit.Test;

/**
 * @author Linbo Ge
 * @date 2020/3/13 - 11:16
 */
public class UserDaoTest {
    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setUsername("Anglelababy");
        loginUser.setPassword("123456");


        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        System.out.println(user);
    }
}
