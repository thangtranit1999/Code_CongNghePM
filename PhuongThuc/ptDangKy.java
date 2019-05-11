/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code_CongNghePM.PhuongThuc;

import java.sql.ResultSet;
import javax.print.DocFlavor;
import javax.swing.JOptionPane;

/**
 *
 * @author Tran Thang
 */
public class ptDangKy {
    String[] dl = new String[8];
    String chuoi;
    public ptDangKy(String[] dl) {
        this.dl=dl;
        traUser();
        themSV();
    }
    
    ketNoi kn = new ketNoi();
    public boolean traUser(){
        try {
            kn.ketNoi();
            String sql="select username from taiKhoan where username='"+dl[6]+"';";
            kn.stmt = kn.cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = kn.stmt.executeQuery(sql);
            if(rs.next()==true)
                return true;
            /*while(rs.next()){
                a+=rs.getString("username");   
            }*/
            
            kn.ngatketnoi();
        } catch (Exception e) {
            
        }
        return false;
    }
    
    public String getChuoi(){
        return this.chuoi;
    }
    private void themSV(){
        try {
                kn.ketNoi();
                String sql1="insert into sinhVien(hoTen, gioiTinh, ngaySinh, email, dienThoai, queQuan, userName) "
                        +"values('"+dl[0]+"','"+dl[1]+"','"+dl[2]
                        +"','"+dl[3]+"','"+dl[4]+"','"+dl[5]+"','"+dl[6]+"')";
                kn.stmt.executeUpdate(sql1);
                String sql2="insert into taiKhoan(userName, passWord, class) "
                        +"values('"+dl[6]+"','"+dl[7]+"','2')";
                kn.stmt.executeUpdate(sql2);
                chuoi = "Bạn đã đăng ký thành công";
                kn.ngatketnoi();
            } catch (Exception e) {
                chuoi= e.toString();
            }
    }
}
