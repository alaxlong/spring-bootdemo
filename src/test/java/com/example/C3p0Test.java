package com.example;

import com.example.util.MysqlC3p0Helper;
import com.example.util.MysqlC3p0Pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: baibing.shang
 * \* Date: 2018/8/15
 * \* Description:
 * \
 */
public class C3p0Test {
    public static void main(String[] args){
        Connection connection = MysqlC3p0Pool.getInstance().getConnection();
        ResultSet rs = MysqlC3p0Helper.executeQuery(connection, "select * from applicationlog");
        try {
            if (rs.next()) {
                String str = rs.getString(2);
                System.out.println(str);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        //这里也可以继续使用connection这个连接，只要上面不关闭即可
        Connection connection1 = MysqlC3p0Pool.getInstance().getConnection();
        int exeCount = 0;
        try {
            exeCount = MysqlC3p0Helper.executeUpdate(connection1, "update applicationlog set data = '0000000' where txid = 'xoxo'");
            connection1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("受影响的行数为：" + exeCount);
    }
}