package Code_CongNghePM.PhuongThucHayDung;


import java.io.Serializable;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Than
 */
public class Student implements Serializable {

    private String hoTen,ngaySinh,email,dienThoai,queQuan,userName,nganh;
    private int ID;
    private float toan,van,anh;
    private boolean gioiTinh;

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String name) {
        this.hoTen = name;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setgioiTinh(boolean address) {
        this.gioiTinh = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String phone) {
        this.dienThoai = phone;
    }

    public int getSBD() {
        return ID;
    }

    public void setSBD(int ID) {
        this.ID = ID;
    }

    public String getNgaySinh(){
        return ngaySinh;
    }
    public void setNgaySinh(String ns){
        this.ngaySinh=ns;
    }
    
    public String getQueQuan(){
        return queQuan;
    }
    public void setQueQuan(String ns){
        this.queQuan=ns;
    }
    
    public String getuser(){
        return userName;
    }
    public void setUser(String ns){
        this.userName=ns;
    }
    public String getNganh  (){
        return nganh;
    }
    public void setNganh(String ns){
        this.nganh=ns;
    }
    public float getToan(){
        return toan;
    }
    public void setToan(float toan){
        this.toan = toan;
    }
    public float getVan(){
        return van;
    }
    public void setVan(float toan){
        this.van = toan;
    }
    public float getAnh(){
        return anh;
    }
    public void setAnh(float toan){
        this.anh = toan;
    }
}
