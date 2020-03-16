package com.xducs.dao.impl;

import com.xducs.dao.UserDao;
import com.xducs.domain.User;
import com.xducs.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * @author Linbo Ge
 * @date 2020/3/16 - 16:11
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //使用Jdbc操作数据库
        //1.定义sql
        String str = "select * from user";
        List<User> users = template.query(str, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }
}
