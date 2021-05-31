/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
/**
 *
 * @author DLH
 */
public class DoiMKDAO {
    dbConnect conn;
    public DoiMKDAO()
    {
        conn = new dbConnect();
        conn.initConnect();
    }
    public boolean UpdatetData(String tk, String mkcu, String mkmoi)
    {
        String sql = "update taikhoan set MatKhau = '"+mkmoi+"' where TaiKhoan = '"+tk+"' and MatKhau = '"+mkcu+"'";
        try
        {
            Statement st = conn.getConn().createStatement();
            return st.executeUpdate(sql) > 0;
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
       return false;
    }//them 
}
