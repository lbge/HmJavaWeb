package com.xducs.dao;

import com.xducs.domain.User;
import com.xducs.util.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Linbo Ge
 * @date 2020/3/21 - 15:57
 */
public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    public User findUser(String username) {

        try {
            String sql = "select * from user where username = ? ";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
            return user;
        } catch (DataAccessException e) {
            return null;
        }

    }
}
