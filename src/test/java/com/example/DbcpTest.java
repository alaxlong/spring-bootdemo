package com.example;

import com.example.util.MysqlDbcpPool;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: baibing.shang
 * \* Date: 2018/8/15
 * \* Description:
 * \
 */
public class DbcpTest {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            //获取数据库连接
            conn = MysqlDbcpPool.getConnection();
            String sql = "insert into applicationlog values(?,?)";
            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, "xoxo");
            st.setString(2, "dddd");
            st.executeUpdate();
            //获取数据库自动生成的主键
            rs = st.getGeneratedKeys();
            if(rs.next()){
                System.out.println(rs.getInt(1));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            MysqlDbcpPool.release(conn, st, rs);
        }
    }
}