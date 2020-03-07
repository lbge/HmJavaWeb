package com.xducs.jdbc;

import java.sql.*;

/**
 * @author Linbo Ge
 * @date 2020/2/29 - 14:49
 */
public class jdbcDemo6 {
    public static void main(String[] args) {

        //如果在try里面定义，作用域就限制在try里，finally里无法找到
        Statement stmt = null;
        Connection coon = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String sql = "select * from person";

            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                    "root",
                    "Ge0824..//");

            stmt = coon.createStatement();

            rs = stmt.executeQuery(sql);
            rs.next();
            int id = rs.getInt(1);
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String phone = rs.getString("phone");
            System.out.println(id+"-"+name+"-"+age+"-"+phone);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //避免空指针异常，如果执行不到stmt赋值就跳出
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

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
