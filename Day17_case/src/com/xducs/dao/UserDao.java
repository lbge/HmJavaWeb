package com.xducs.dao;

import com.xducs.domain.User;

import java.util.List;

/**用户操作的Dao
 * @author Linbo Ge
 * @date 2020/3/16 - 16:09
 */
public interface UserDao {
    public List<User> findAll();
}
