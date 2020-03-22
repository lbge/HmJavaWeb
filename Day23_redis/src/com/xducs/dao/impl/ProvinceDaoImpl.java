package com.xducs.dao.impl;

import com.xducs.dao.ProvinceDao;
import com.xducs.domain.Province;
import com.xducs.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Linbo Ge
 * @date 2020/3/22 - 15:23
 */
public class ProvinceDaoImpl implements ProvinceDao {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {

        String sql = "select * from province";
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
