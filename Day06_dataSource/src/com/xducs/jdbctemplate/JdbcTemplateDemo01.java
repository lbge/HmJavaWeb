package com.xducs.jdbctemplate;

import com.xducs.utils.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Linbo Ge
 * @date 2020/3/1 - 15:17
 */
public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建template对象
        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
        //3.调用方法
        String sql = "update account set userName = ? where id = ?";
        int count = template.update(sql, "Joy",1);
        System.out.println(count);
    }
}
