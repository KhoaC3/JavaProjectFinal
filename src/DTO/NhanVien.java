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
public class NhanVien {
    private int id;
    private String name;
    private String NgaySinh;
    private String CMND;
    private String DiaChi;
    private String SDT;
    private String Email;
    private String ChuThich;

    public NhanVien(String name, String NgaySinh, String CMND, String DiaChi, String SDT, String Email, String ChuThich) {
        this.name = name;
        this.NgaySinh = NgaySinh;
        this.CMND = CMND;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Email = Email;
        this.ChuThich = ChuThich;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getChuThich() {
        return ChuThich;
    }

    public void setChuThich(String ChuThich) {
        this.ChuThich = ChuThich;
    }
    
}
