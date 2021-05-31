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
public class DangNhapDAO {
    dbConnect conn;
    public DangNhapDAO()
    {
        conn = new dbConnect();//khoi tao class ket noi
        conn.initConnect();
    }
    public ResultSet getAllData(String tk, String mk)
    {
        ResultSet rs = null;
        String sql = "select * from taikhoan where TaiKhoan = '"+tk+"' and MatKhau = '"+mk+"'";
        try
        {
            Statement st = conn.getConn().createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return rs;
    }//ham lay du l
}
