package com.xducs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Linbo Ge
 * @date 2020/2/29 - 12:23
 */
public class jdbcDemo2 {

    public static void main(String[] args) {
        //如果在try里面定义，作用域就限制在try里，finally里无法找到
        Statement stmt = null;
        Connection coon = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String sql = "insert into account value(null,'wangwu',998)";

            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                    "root",
                    "Ge0824..//");

            stmt = coon.createStatement();

            int count = stmt.executeUpdate(sql);

            System.out.println(count);

            if (count > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //避免空指针异常，如果执行不到stmt赋值就跳出
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (coon != null) {
                try {
                    coon.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
