package com.sprAnnotation.distributeTransaction;


import com.mysql.cj.jdbc.JdbcConnection;
import com.mysql.cj.jdbc.MysqlXAConnection;
import com.mysql.cj.jdbc.MysqlXid;

import javax.sql.XAConnection;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DTResolve {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/clouddb01?serverTimezone=GMT%2B8";
        String url2 = "jdbc:mysql://localhost:3306/clouddb02?serverTimezone=GMT%2B8";

        String username = "root";
        String password = "18d0b61;9";
        //String classname = "com.mysql.jdbc.Driver";
        Connection con1 = null;
        Connection con2 = null;
        try {


            // 新版mysql 无需注册
            // Class.forName(classname);
            con1 = DriverManager.getConnection(url, username, password);
            con2 = DriverManager.getConnection(url2, username, password);

            // true 打印日志
            XAConnection xaCon1 = new MysqlXAConnection((JdbcConnection) con1, true);
            XAConnection xaCon2 = new MysqlXAConnection((JdbcConnection) con2, true);

            XAResource xaResource1 = xaCon1.getXAResource();
            XAResource xaResource2 = xaCon2.getXAResource();

            // 准备提交事务, 返回结果
            int xaVal1 = XAResource.TMNOFLAGS;
            int xaVal2 = XAResource.TMNOFLAGS;

            // 生成事务分支 Id
            Xid xid1 = new MysqlXid("gtrid001".getBytes(), "bqual001".getBytes(), 1);
            Xid xid2 = new MysqlXid("gtrid002".getBytes(), "bqual002".getBytes(), 2);

            // 事务一 开始
            xaResource1.start(xid1, xaVal1);
            PreparedStatement stat1 = con1.prepareStatement("insert into dept values (4, '设计部', 'clouddb01')");
            stat1.executeUpdate();
            // 事务一 结束
            xaResource1.end(xid1, XAResource.TMSUCCESS);


            // 事务二 开始
            xaResource2.start(xid2, xaVal2);
            PreparedStatement stat2 = con2.prepareStatement("insert into dept values (4, '设计部', 'clouddb02')");
            stat2.executeUpdate();
            // 事务二  结束

            int a = 1/0;
            xaResource2.end(xid2, XAResource.TMSUCCESS);


            // 预备阶段
            xaVal1 = xaResource1.prepare(xid1);
            xaVal2 = xaResource2.prepare(xid2);

            // *********************** 两阶段提交 ***********************

            boolean allCommit = false;
            if (xaVal1 == XAResource.XA_OK && xaVal2 == XAResource.XA_OK) {
                xaResource1.commit(xid1, allCommit);
                xaResource2.commit(xid2, allCommit);
            } else {
                xaResource1.rollback(xid1);
                xaResource2.rollback(xid2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con1 != null) {
                try {
                    con1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con2 != null) {
                try {
                    con2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
