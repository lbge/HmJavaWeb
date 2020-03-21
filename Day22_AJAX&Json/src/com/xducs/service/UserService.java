package com.xducs.service;

import com.xducs.dao.UserDao;
import com.xducs.domain.User;

/**
 * @author Linbo Ge
 * @date 2020/3/21 - 15:57
 */
public class UserService {
    public User regist(String username){
        UserDao dao = new UserDao();
        return  dao.findUser(username);
    }
}
