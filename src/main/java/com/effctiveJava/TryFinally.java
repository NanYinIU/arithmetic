package com.effctiveJava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class TryFinally {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.dirver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_demo?useSSL=false&serverTimezone=UTC","root","password");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name, url FROM websites";
            ResultSet rs = stmt.executeQuery(sql);
            //...
        }catch (ClassNotFoundException cnf){
            // log..驱动不存在
        }catch (SQLException sql){
            // log..sqlException
        }finally {
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    public void copy() throws IOException {
        try(FileInputStream fileInputStream = new FileInputStream("src");
            FileOutputStream fileOutputStream = new FileOutputStream("dst")){
            // ....
            Object object = new Object();
        }
    }
}
