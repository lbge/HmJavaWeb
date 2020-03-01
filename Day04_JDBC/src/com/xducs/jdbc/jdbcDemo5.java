package com.xducs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Linbo Ge
 * @date 2020/2/29 - 13:09
 */
public class jdbcDemo5 {
    public static void main(String[] args) {

        //如果在try里面定义，作用域就限制在try里，finally里无法找到
        Statement stmt = null;
        Connection coon = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String sql1 = "create table person (id int primary key ,name varchar(20) unique, sex char not null,age int default 15,phone varchar(11))";
            String sql2 = "insert into person(id,name,sex,age,phone) " +
                    "value(3,'王语嫣','女',default ,'1565656')";
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                    "root",
                    "Ge0824..//");

            stmt = coon.createStatement();

            int count1 = stmt.executeUpdate(sql1);
            int count2 = stmt.executeUpdate(sql2);

            System.out.println(count1);


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
