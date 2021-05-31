/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.NhanVien;
import java.sql.*;
/**
 *
 * @author DLH
 */
public class NhanVienDAO {
    dbConnect conn;
    public NhanVienDAO()
    {
        conn = new dbConnect();//khoi tao class ket noi
        conn.initConnect();//goi phuong thuc ket noi
    }
    public ResultSet getAllData()
    {
        ResultSet rs = null;
        String sql = "select nhanvien.ID, nhanvien.TenNV, NgaySinh, CMND, DiaChi, SDT, Email, ChuThich from nhanvien";
        try
        {
            Statement st = conn.getConn().createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return rs;
    }//ham lay du lieu tu csdl
    public void InsertData(NhanVien data)
    {
        String sql = "insert into nhanvien values("+null+",'"+data.getName()+"','"+data.getNgaySinh()+"','"+data.getCMND()+"','"+data.getDiaChi()+"','"+data.getSDT()+"','"+data.getEmail()+"','"+data.getChuThich()+"')";
        try
        {
            Statement st = conn.getConn().createStatement();
            st.executeUpdate(sql);
            st.close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
       
    }//ham nhap du lieu vao csdl
    public boolean UpdatetData(NhanVien data)
    {
        String sql = "update nhanvien set TenNV = '"+data.getName()+"',NgaySinh = '"+data.getNgaySinh()+"',CMND = '"+data.getCMND()+"',DiaChi = '"+data.getDiaChi()+"',SDT = '"+data.getSDT()+"',Email = '"+data.getEmail()+"',ChuThich = '"+data.getChuThich()+"' where ID = '"+data.getId()+"'";
        try
        {
            Statement st = conn.getConn().createStatement();
            st.executeUpdate(sql);
            st.close();
            return true;
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
       return false;
    }//them 
    public boolean DelData(int id)
    {
        String sql = "delete from nhanvien where ID = '"+id+"'";
         try
        {
            if(conn != null)
            {
                Statement st = conn.getConn().createStatement();
                st.executeUpdate(sql);
                st.close();
                return true;
            }
            
        }catch(Exception ex)
        {
            ex.printStackTrace();          
        }
        return false;
    }//xoa
    public ResultSet getAllDataByTen(String name)
    {
        ResultSet rs = null;
        String sql = "select nhanvien.ID, nhanvien.TenNV,NgaySinh, CMND, DiaChi, SDT, Email, ChuThich from nhanvien where nhanvien.TenNV like '%"+name+"%'";
        try
        {
            Statement st = conn.getConn().createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return rs;
    }//tim kiem theo ten
}
