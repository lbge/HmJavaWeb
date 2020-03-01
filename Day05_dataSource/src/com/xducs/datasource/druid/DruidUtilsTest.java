package com.xducs.datasource.druid;

import com.xducs.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Linbo Ge
 * @date 2020/3/1 - 14:49
 */
public class DruidUtilsTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //1.获取连接
            conn = JdbcUtils.getConn();
            //2.定义sql
            String sql = "insert into account values(null,?,?)";
            //3.获取执行sql对象
            pstmt = conn.prepareStatement(sql);
            //4.赋值
            pstmt.setString(1, "John");
            pstmt.setDouble(2, 2500);
            //5.执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            JdbcUtils.close(pstmt, conn);
        }
    }
}
