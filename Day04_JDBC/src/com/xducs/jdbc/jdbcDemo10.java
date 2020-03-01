package com.xducs.jdbc;

import com.xducs.util.jdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务的操作
 *
 * @author Linbo Ge
 * @date 2020/2/29 - 19:29
 */
public class jdbcDemo10 {
    public static void main(String[] args) {
        Connection coon = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            //1.获取连接
            coon = jdbcUtils.getConnection();
            //开启事务
            coon.setAutoCommit(false);
            //2.定义sql
            String sql1 = "update account set balance = balance - ? where userName = ? ";
            String sql2 = "update account set balance = balance + ? where userName = ? ";
            //3.获取执行sql对象
            pstmt1 = coon.prepareStatement(sql1);
            pstmt2 = coon.prepareStatement(sql2);
            //4.设置参数
            pstmt1.setDouble(1, 500);
            pstmt1.setString(2, "ppp");
            pstmt2.setDouble(1, 500);
            pstmt2.setString(2, "wangwu");
            //5.执行sql语句
            pstmt1.executeUpdate();
            //手动制造异常
//            int i = 3 / 0;
            pstmt2.executeUpdate();
            coon.commit();
        } catch (Exception e) {
            try {
                if (coon != null) {
                    coon.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            jdbcUtils.close(pstmt1, coon);
            jdbcUtils.close(pstmt2, null);
        }
    }
}
