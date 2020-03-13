package com.xducs.dao;

import com.xducs.domain.User;
import com.xducs.util.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中User表的类
 *
 * @author Linbo Ge
 * @date 2020/3/13 - 10:53
 */
public class UserDao {
    /**
     * 声明JDBCTemplate对象共用
     */
    private JdbcTemplate template = null;

    public UserDao(){
        template = new JdbcTemplate(JdbcUtils.getDataSource());
    }

    /**
     * 登录方法
     *
     * @param loginUser 只需要用户名和密码的User对象
     * @return user 包含用户全部数据,无匹配对象返回null
     */
    public User login(User loginUser) {
        try {
            //编写sql
            String sql = "select * from user where username = ? and password = ?";
            //调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
