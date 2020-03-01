package com.xducs.datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Linbo Ge
 * @date 2020/3/1 - 12:57
 */
public class DruidDemo01 {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties pro = new Properties();

        ClassLoader cl = DruidDemo01.class.getClassLoader();
        /*URL res = cl.getResource("druid.properties");
        String path = res.getPath();
        System.out.println(path);
        pro.load(new FileReader(path));
        */
        InputStream is = cl.getResourceAsStream("druid.properties");
        pro.load(is);
        //获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        //获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
