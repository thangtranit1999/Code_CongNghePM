/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code_CongNghePM.PhuongThucHayDung;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Code_CongNghePM.PhuongThuc.ketNoi;

/**
 *
 * @author Tran Thang
 */
public class dayDuLieuSinhVien {
    ketNoi kn = new ketNoi();
    public ArrayList<Student> getListStudent(){
        ArrayList<Student> list = new ArrayList<>();
        try {
            kn.ketNoi();
            String sql = "SELECT * FROM sinhVien";
            ResultSet rs = kn.stmt.executeQuery(sql);
            while(rs.next()){
                Student s = new Student();
                s.setSBD(rs.getInt("SBD"));
                s.setHoTen(rs.getString("hoTen"));
                s.setgioiTinh(rs.getBoolean("gioiTinh"));
                s.setNgaySinh(rs.getString("ngaySinh"));
                s.setEmail(rs.getString("email"));
                s.setDienThoai(rs.getString("dienThoai"));
                s.setQueQuan(rs.getString("queQuan"));
                s.setNganh(rs.getString("nganh"));
                s.setUser(rs.getString("userName"));
                list.add(s);
            }
            kn.ngatketnoi();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    public ArrayList<Student> getListDiem(){
    ArrayList<Student> list = new ArrayList<>();
        try {
            kn.ketNoi();
            String sql="SELECT * from SQLdiemSV";
            ResultSet rs = kn.stmt.executeQuery(sql);
            while(rs.next()){
                Student s = new Student();
                s.setSBD(rs.getInt("SBD"));
                System.out.println(rs.getString("hoTen"));
                s.setHoTen(rs.getString("hoTen"));
                System.out.println(rs.getInt("toan"));
                
                s.setToan(rs.getFloat("toan"));
                s.setVan(rs.getFloat("van"));
                s.setAnh(rs.getFloat("anh"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return list;
}
}
