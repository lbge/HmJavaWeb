package com.xducs.dao;

import com.xducs.domain.Admin;
import com.xducs.domain.User;

import java.util.List;
import java.util.Map;

/**用户操作的Dao
 * @author Linbo Ge
 * @date 2020/3/16 - 16:09
 */
public interface UserDao {
     List<User> findAll();

     Admin findAdmin(String username,String password);

     void addUser(User user);

     void delUser(int id);

     User findUserById(int id);

     void updateUser(User user);

    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
