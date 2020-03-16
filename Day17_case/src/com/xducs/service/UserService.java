package com.xducs.service;

import com.xducs.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 * @author Linbo Ge
 * @date 2020/3/16 - 16:05
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

}
