package com.xducs.jdbc;

import java.sql.*;

/**
 * @author Linbo Ge
 * @date 2020/2/29 - 14:49
 */
public class jdbcDemo7 {
    public static void main(String[] args) {
        //如果在try里面定义，作用域就限制在try里，finally里无法找到
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                    "root",
                    "Ge0824..//");
            String sql = "select * from account";
            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString("userName");
                double balance = rs.getDouble("balance");
                System.out.println(id + "-" + name + "-" + balance);
            }
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

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
