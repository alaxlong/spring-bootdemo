package com.example.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: baibing.shang
 * \* Date: 2018/8/15
 * \* Description:
 * \
 */
public class MysqlC3p0Pool {
    private static final MysqlC3p0Pool instance = new MysqlC3p0Pool();
    private static ComboPooledDataSource comboPooledDataSource;

    private MysqlC3p0Pool() {
    }

    public static MysqlC3p0Pool getInstance() {
        return instance;
    }

    static {
        try {
            //创建Properties对象
            Properties pro = new Properties();
            //获取输入流
            InputStream in = MysqlC3p0Pool.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //加载输入流
            pro.load(in);

            String driver = pro.getProperty("driverClassName");
            String url = pro.getProperty("url");
            String username = pro.getProperty("username");
            String password = pro.getProperty("password");

            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            comboPooledDataSource = new ComboPooledDataSource();
            comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
            comboPooledDataSource.setJdbcUrl(url);
            comboPooledDataSource.setUser(username);
            comboPooledDataSource.setPassword(password);
            //下面是设置连接池的一配置
            comboPooledDataSource.setMaxPoolSize(20);
            comboPooledDataSource.setMinPoolSize(5);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized static Connection getConnection() {
        Connection connection = null;
        try {
            connection = comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return connection;
        }
    }
}