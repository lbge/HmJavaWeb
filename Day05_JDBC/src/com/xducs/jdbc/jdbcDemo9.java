package com.xducs.jdbc;

import com.xducs.util.jdbcUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Linbo Ge
 * @date 2020/2/29 - 17:12
 */
public class jdbcDemo9 {

    public static void main(String[] args) {
        //1.键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        //2.调用方法
        boolean flag = new jdbcDemo9().login2(username, password);
        //3.判断结果
        if (flag) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

    }

    /**
     * 登录方法
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回
     */
    public boolean login1(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        //链接数据库判断是否登录成功
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        //1。获取链接

        try {
            conn = jdbcUtils.getConnection();
            //2.定义sql
            String sql = "select * from user where username = '" + username + "' and password = '" + password + "' ";
            System.out.println(sql);
            //3.获取执行sql的对象
            stmt = conn.createStatement();
            //4.执行sql语句
            rs = stmt.executeQuery(sql);
            //5.处理结果
          /*  if (rs.next()) {
                return true;
            }else {
                return false;
            }*/
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.close(rs, stmt, conn);
        }
        //如果出现异常，则返回false
        return false;
    }

    /**
     * 使用paperStatement实现
     *
     * @param username
     * @param password
     * @return
     */
    public boolean login2(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        //链接数据库判断是否登录成功
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //1。获取链接

        try {
            conn = jdbcUtils.getConnection();
            //2.定义sql
            String sql = "select * from user where username = ? and password = ? ";
            //3.获取执行sql的对象
            pstmt = conn.prepareStatement(sql);
            //给?赋值
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            //4.执行sql查询，不需要传递
            rs = pstmt.executeQuery();
            //5.处理结果
          /*  if (rs.next()) {
                return true;
            }else {
                return false;
            }*/
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.close(rs, pstmt, conn);
        }
        //如果出现异常，则返回false
        return false;
    }
}
