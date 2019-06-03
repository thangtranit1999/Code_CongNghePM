/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code_CongNghePM.PhuongThucHayDung;

import Code_CongNghePM.PhuongThuc.ketNoi;
import javax.swing.JOptionPane;

/**
 *
 * @author Tran Thang
 */
public class themSuaXoa {
    String chuoi;
    ketNoi kn = new ketNoi();

    public themSuaXoa(String sql1,String sql2, String sql3){//3 sql để xóa
        xoaSinhvien(sql1);
        xoaSinhvien(sql2);
        xoaSinhvien(sql3);
    }
    public themSuaXoa(String sql){//một sql để sửa điểm
        sua(sql);
    }
    public themSuaXoa(String sql,String loai){
        them(sql);
    }
    
    private void sua(String sql){
        try
        {
            kn.ketNoi();
            kn.stmt.executeUpdate(sql);
            this.chuoi=("Bạn đã sửa thành công");
            kn.ngatketnoi();
        }
        catch(Exception ex)
        {
            this.chuoi="Đã xảy ra lỗi";
            System.out.println(ex.toString());
        }   
    }
    private void them(String sql){
        try
        {
            kn.ketNoi();
            kn.stmt.executeUpdate(sql);
            this.chuoi=("Bạn đã sửa thành công");
            kn.ngatketnoi();
        }
        catch(Exception ex)
        {
            this.chuoi="Đã xảy ra lỗi";
            System.out.println(ex.toString());
        }   
    }
    private void xoaSinhvien(String sql){
        try {
                kn.ketNoi();
                kn.stmt.executeUpdate(sql);
                this.chuoi = "Bạn đã xóa thành công";
                kn.ngatketnoi();
            } catch (Exception e) {
                this.chuoi="đã xảy ra lỗi";
                System.out.println(e.toString());
            }
    }
    public String getChuoi(){
        return this.chuoi;
    }
}
