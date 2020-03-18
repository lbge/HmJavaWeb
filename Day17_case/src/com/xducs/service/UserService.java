package com.xducs.service;

import com.xducs.domain.Admin;
import com.xducs.domain.PageBean;
import com.xducs.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 *
 * @author Linbo Ge
 * @date 2020/3/16 - 16:05
 */
public interface UserService {
    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> findAll();

    /**
     * 登录
     *
     * @param admin
     * @return
     */
    Admin login(Admin admin);

    /**
     * 添加用户
     *
     * @return
     */
    void addUser(User user);

    /**
     * 删除用户
     *
     * @param id 数据id
     */
    void delUser(String id);

    /**
     * 根据id查找对象
     *
     * @param id id
     * @return
     */
    User findUserById(String id);

    /**
     * 修改
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 批量删除
     *
     * @param ids
     */
    void delSelected(String[] ids);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
