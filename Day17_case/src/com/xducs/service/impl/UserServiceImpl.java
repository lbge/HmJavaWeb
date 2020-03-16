package com.xducs.service.impl;

import com.xducs.dao.UserDao;
import com.xducs.dao.impl.UserDaoImpl;
import com.xducs.domain.User;
import com.xducs.service.UserService;

import java.util.List;

/**
 * @author Linbo Ge
 * @date 2020/3/16 - 16:08
 */
public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }
}
