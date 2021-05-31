/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.LoaiHangHoa;
import java.sql.*;
/**
 *
 * @author DLH
 */
public class LoaiHangHoaDAO {
    dbConnect conn;
    public LoaiHangHoaDAO()
    {
        conn = new dbConnect();//khoi tao class ket noi
        conn.initConnect();//goi phuong thuc ket noi
    }
    public ResultSet getAllData()
    {
        ResultSet rs = null;
        String sql = "select loaihanghoa.ID, loaihanghoa.Name, nhacungcap.Name from loaihanghoa,nhacungcap where loaihanghoa.IDNCC = nhacungcap.ID";
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
    public void InsertData(LoaiHangHoa data)
    {
        String sql = "insert into loaihanghoa values("+null+",'"+data.getName()+"','"+data.getIdNCC()+"')";
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
    public boolean UpdatetData(LoaiHangHoa data)
    {
        String sql = "update loaihanghoa set Name = '"+data.getName()+"',ID = '"+data.getId()+"' where ID = '"+data.getId()+"'";
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
        String sql = "delete from loaihanghoa where ID = '"+id+"'";
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
        String sql = "select loaihanghoa.ID, loaihanghoa.Name, nhacungcap.Name from loaihanghoa,nhacungcap where loaihanghoa.IDNCC = nhacungcap.ID and loaihanghoa.Name like '%"+name+"%'";
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
    public ResultSet getTenNCC()
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
    public ResultSet getIDNCC(String ten)
    {
        ResultSet rs = null;
        String sql = "select ID from nhacungcap where Name = '"+ten+"'";
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


    

