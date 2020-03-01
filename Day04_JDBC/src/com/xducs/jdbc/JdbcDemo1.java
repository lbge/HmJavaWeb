package com.xducs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author Linbo Ge
 * @date 2020/2/29 - 10:18
 */
public class JdbcDemo1 {

    public static void main(String[] args) throws Exception {
        //导入jar包
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "Ge0824..//");
        //定义sql语句
        String sql = "update account set balance = 699 where id = 1";
        //获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //执行sql，返回的是影响的行数
        int count = stmt.executeUpdate(sql);
        //处理结果
        System.out.println(count);
        //释放资源
        stmt.close();
        conn.close();
    }
}
