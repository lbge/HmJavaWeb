package com.xducs.jdbctemplate;

import com.xducs.domain.Emp;
import com.xducs.utils.JdbcUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Linbo Ge
 * @date 2020/3/1 - 15:59
 */
public class JdbcTemplateTest {

    //Junit单元测试，可以让方法独立执行
    /**
     * 获取JDBCTemplate对象
     */
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    /**
     * 1.修改100号数据的 salary 为 10000
     */
    @Test
    public void test01() {

        String sql = "update employees set salary = 10000 where employee_id = ?";
        int count = template.update(sql, 100);
        System.out.println(count);
    }

    /**
     * 2. 添加一条记录
     */
    @Test
    public void test02() {
        String sql = "insert into employees(employee_id,last_name,email,salary) value(null,?,?,?) ";
        template.update(sql, "杨峰", "yf@mail.com", "12000");
    }

    /**
     * 3. 删除刚才添加的记录
     */
    @Test
    public void test03() {
        String sql = "delete from employees where employee_id = ?";
        int count = template.update(sql, 209);
        System.out.println(count);
    }

    /**
     * 4. 查询id为1的记录，将其封装为Map集合
     * 查询的结果集长度只能是1
     */
    @Test
    public void test04() {
        String sql = "select * from employees where employee_id = ?";
        Map<String, Object> map = template.queryForMap(sql, 100);
        System.out.println(map);
    }

    /**
     * 5. 查询所有记录，将其封装为List
     */
    @Test
    public void test05() {
        String sql = "select * from employees";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }

    /**
     * 6. 查询所有记录，将其封装为Emp对象的List集合
     */
    @Test
    public void test06() {
        String sql = "select * from employees";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {

            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
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

                Emp emp = new Emp();
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
                return emp;
            }
        });
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 6. 查询所有记录，将其封装为Emp对象的List集合
     */
    @Test
    public void test06_2() {
        String sql = "select * from employees";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 7. 查询总记录数
     */
    @Test
    public void test07() {
        String sql = "select count(employee_id) from employees";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
