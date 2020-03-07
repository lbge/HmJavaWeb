package com.xducs.domain;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Linbo Ge
 * @date 2020/2/29 - 15:22
 */
public class JdbcTest {

    public static void main(String[] args) {
        List<Emp> list = new JdbcTest().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }
    /**
     * 查询所有employee内容
     */
    public List<Emp> findAll() {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取链接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC",
                    "root",
                    "Ge0824..//");
            //3.定义sql
            String sql = "select * from employees ";
            //4.获取执行sql对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集,封装对象，装载集合
            Emp emp = null;
            list = new ArrayList<Emp>();
            while (rs.next()) {
                //获取数据
                int id = rs.getInt("employee_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone_number");
                String jobId = rs.getString("job_id");
                double salary = rs.getDouble("salary");
                double commission = rs.getDouble("commission_pct");
                int departmentId = rs.getInt("department_id");
                int managerId = rs.getInt("manager_id");
                Date hireDate = rs.getDate("hiredate");
                //创建emp对象
                emp = new Emp();
                emp.setId(id);
                emp.setFirstName(firstName);
                emp.setLastName(lastName);
                emp.setEmail(email);
                emp.setPhone(phone);
                emp.setJobId(jobId);
                emp.setSalary(salary);
                emp.setCommission(commission);
                emp.setDepartmentId(departmentId);
                emp.setManagerId(managerId);
                emp.setHireDate(hireDate);
                //装载集合
                list.add(emp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
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
        return list;
    }
}
