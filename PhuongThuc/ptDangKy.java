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
        sql1();
        int id=getID();
        sql2(id);
        themSV(id);
    }
    
    ketNoi kn = new ketNoi();
    public boolean traUser(){
        try {
            kn.ketNoi();
            String sql="select username from taiKhoanSV where username='"+dl[6]+"';";
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
    void sql1(){
        if(traUser()==true){
            chuoi="Đã tồn tại user này";
        }
        else{
            try {
                kn.ketNoi();
                String sql1="insert into sinhVien(hoTen, gioiTinh, ngaySinh, email, dienThoai, queQuan, userName) "
                        +"values('"+dl[0]+"','"+dl[1]+"','"+dl[2]
                        +"','"+dl[3]+"','"+dl[4]+"','"+dl[5]+"','"+dl[6]+"')";
                kn.stmt.executeUpdate(sql1);
                kn.ngatketnoi();
            } catch (Exception e) {
                chuoi= e.toString();
            }
        }
    }
    void sql2(int id){
        try {
                kn.ketNoi();
                String sql2="insert into taiKhoanSV(SBD,name,userName, passWord, class) "
                        +"values('"+id+"','"+dl[0]+"','"+dl[6]+"','"+dl[7]+"','2')";
                kn.stmt.executeUpdate(sql2);
                chuoi = "Bạn đã đăng ký thành công";
                kn.ngatketnoi();
            } catch (Exception e) {
                chuoi= e.toString();
            }
    }
    private void themSV(int id){

            try {
                kn.ketNoi();
                String sql3="insert into diemSV(SBD,toan,van,anh) "
                        +"values('"+id+"','0','0','0')";
                kn.stmt.executeUpdate(sql3);
                chuoi = "Bạn đã đăng ký thành công";
                kn.ngatketnoi();
            } catch (Exception e) {
                chuoi= e.toString();
            }
    }
    private int getID(){
        int id=0;
        try {
            kn.ketNoi();
            String sql="SELECT SBD FROM sinhVien where userName='"+dl[6]+"'";
            ResultSet rs = kn.stmt.executeQuery(sql);
            while(rs.next()){
                id=rs.getInt("SBD");
                System.out.println("ID trong"+rs.getInt("SBD"));
            }
            kn.ngatketnoi();
        } catch (Exception e) {
            
        }
        System.out.println("ID:"+id);
        return id;
    }
}
