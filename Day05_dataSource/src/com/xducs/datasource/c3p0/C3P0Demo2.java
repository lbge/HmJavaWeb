package com.xducs.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Linbo Ge
 * @date 2020/3/1 - 12:28
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
//        DataSource ds = new ComboPooledDataSource();
        DataSource ds = new ComboPooledDataSource();
        for (int i = 1; i <= 7 ; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);

        }
    }
}
