/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.NhaCungCap;
import java.sql.*;
/**
 *
 * @author DLH
 */
public class NhaCungCapDAO {
    dbConnect conn;
    public NhaCungCapDAO()
    {
        conn = new dbConnect();//khoi tao class ket noi
        conn.initConnect();//goi phuong thuc ket noi
    }
    public ResultSet getAllData()
    {
        ResultSet rs = null;
        String sql = "select nhacungcap.ID, nhacungcap.Name, nhacungcap.DiaChi, nhacungcap.SDT, nhacungcap.Email, nhacungcap.ChuThich from nhacungcap";
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
    public void InsertData(NhaCungCap data)
    {
        String sql = "insert into nhacungcap values("+null+",'"+data.getName()+"','"+data.getDiachi()+"','"+data.getSdt()+"','"+data.getEmail()+"','"+data.getChuthich()+"')";
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
    public boolean UpdatetData(NhaCungCap data)
    {
        String sql = "update nhacungcap set Name = '"+data.getName()+"',DiaChi = '"+data.getDiachi()+"',SDT = '"+data.getSdt()+"',Email = '"+data.getEmail()+"',ChuThich = '"+data.getChuthich()+"' where ID = '"+data.getId()+"'";
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
        String sql = "delete from nhacungcap where ID = '"+id+"'";
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
        String sql = "select nhacungcap.ID, nhacungcap.Name, nhacungcap.DiaChi, SDT, Email, ChuThich from nhacungcap where nhacungcap.Name like '%"+name+"%'";
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
    public ResultSet getTenNhaCungCap()
    {
        ResultSet rs = null;
        String sql = "select Name from nhacungcap";
        try
        {
            Statement st = conn.getConn().createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return rs;
    }//lay ra tat ca ten loai hang hoa theo
    
}
