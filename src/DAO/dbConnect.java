/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.sql.SQLException;
/**
 *
 * @author DLH
 */
public class dbConnect {
    private Connection conn;
    public void initConnect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doanjava", "root", "");
            //  DriverManager.getConnection(url, user, pass);
            System.out.println("Ket noi CSDL thanh cong");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConn()
    {
        return conn;
    }
}
