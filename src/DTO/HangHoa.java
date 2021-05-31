/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author DLH
 */
//anh xa csdl
public class HangHoa {
    private int id;
    private String name;
    private int idLoai;
    private long sl;
    private String dvt;
    private double giaNhap;
    private double giaXuat;//tu viet lai csdl

    //alt + inset + constructor ... bo id dau tien, con lai tick het
    public HangHoa(String name, int idLoai, long sl, String dvt, double giaNhap, double giaXuat) {
        this.name = name;
        this.idLoai = idLoai;
        this.sl = sl;
        this.dvt = dvt;
        this.giaNhap = giaNhap;
        this.giaXuat = giaXuat;
    }

    public int getId() {
        return id;
    }
//click chuot dong nay + alt insert + geter anh seter
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(int idLoai) {
        this.idLoai = idLoai;
    }

    public long getSl() {
        return sl;
    }

    public void setSl(long sl) {
        this.sl = sl;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaXuat() {
        return giaXuat;
    }

    public void setGiaXuat(double giaXuat) {
        this.giaXuat = giaXuat;
    }

    

    
}
