/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.HangHoa;
import java.sql.*;
/**
 *
 * @author DLH
 */
public class HangHoaDAO {
    dbConnect conn;
    public HangHoaDAO()
    {
        conn = new dbConnect();//khoi tao class ket noi
        conn.initConnect();//goi phuong thuc ket noi
    }
    public ResultSet getAllData()
    {
        ResultSet rs = null;
        String sql = "select quanlyhanghoa.ID, quanlyhanghoa.Name, loaihanghoa.Name, SoLuong, DonViTinh, GiaNhap, GiaXuat from quanlyhanghoa,loaihanghoa where quanlyhanghoa.IDLoai = loaihanghoa.ID";
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
    public void InsertData(HangHoa data)
    {
        String sql = "insert into quanlyhanghoa values("+null+",'"+data.getName()+"','"+data.getIdLoai()+"','"+data.getSl()+"','"+data.getDvt()+"','"+data.getGiaNhap()+"','"+data.getGiaXuat()+"')";
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
    public boolean UpdatetData(HangHoa data)
    {
        String sql = "update quanlyhanghoa set Name = '"+data.getName()+"',IDLoai = '"+data.getIdLoai()+"',SoLuong = '"+data.getSl()+"',DonViTinh = '"+data.getDvt()+"',GiaNhap = '"+data.getGiaNhap()+"',GiaXuat = '"+data.getGiaXuat()+"' where ID = '"+data.getId()+"'";
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
        String sql = "delete from quanlyhanghoa where ID = '"+id+"'";
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
        String sql = "select quanlyhanghoa.ID, quanlyhanghoa.Name, loaihanghoa.Name, SoLuong, DonViTinh, GiaNhap, GiaXuat from quanlyhanghoa,loaihanghoa where quanlyhanghoa.IDLoai = loaihanghoa.ID and quanlyhanghoa.Name like '%"+name+"%'";
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
    public ResultSet getTenLoai()
    {
        ResultSet rs = null;
        String sql = "select Name from loaihanghoa";
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
    public ResultSet getIDLoai(String ten)
    {
        ResultSet rs = null;
        String sql = "select ID from loaihanghoa where Name = '"+ten+"'";
        try
        {
            Statement st = conn.getConn().createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return rs;
    }    
}//lay id hang hoa theo loai hang hoa truyen vao 

