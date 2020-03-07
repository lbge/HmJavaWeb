package com.xducs.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Linbo Ge
 * @date 2020/3/1 - 12:03
 */
public class C3P0Demo {
    public static void main(String[] args) throws SQLException {
        /**
         * 1.创建数据库连接池对象
         */
        DataSource ds = new ComboPooledDataSource();
        /**
         * 2.获取连接对象
         */
        Connection coon = ds.getConnection();
        System.out.println(coon);
    }
}

