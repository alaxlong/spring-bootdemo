package com.example.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: baibing.shang
 * \* Date: 2018/8/15
 * \* Description:
 * \
 */
public class JDBCTools {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            //获取数据库连接
            conn = getConnection();
            String sql = "insert into applicationlog values(?,?)";
            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, "fgg");
            st.setString(2, "dddd");
            st.executeLargeUpdate()/*.executeUpdate()*/;
            //获取数据库自动生成的主键
            rs = st.getGeneratedKeys();
            if(rs.next()){
                System.out.println(rs.getInt(1));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            closeConnection(rs, st, conn);
        }
    }

    public static Connection getConnection() throws Exception{
        //创建Properties对象
        Properties pro = new Properties();
        //获取输入流
        InputStream in = JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");
        //加载输入流
        pro.load(in);

        String driver = pro.getProperty("driverClassName");
        String jdbcUrl = pro.getProperty("url");
        String user = pro.getProperty("username");
        String password = pro.getProperty("password");
        //加载数据库驱动程序
        Class.forName(driver);
        //通过DriverManager的getConnection()方法获取数据库连接
        Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
        return conn;
    }
    /**
     * 功能：关闭数据库连接
     * @param rs
     * @param statement
     * @param conn
     */
    public static void closeConnection(ResultSet rs, Statement statement, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(statement != null){

            try {
                statement.close();
            } catch (Exception e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (Exception e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
        }
    }
}