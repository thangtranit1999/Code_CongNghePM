/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code_CongNghePM.DieuKhien;
import Code_CongNghePM.PhuongThuc.dangNhap;
import Code_CongNghePM.dangKy;
import Code_CongNghePM.giaoDienChinhChoGiaoVien;

/**
 *
 * @author Tran Thang
 */
public class dkDangNhap {
    dangNhap dn;
    String tb="";
    public dkDangNhap(String[] dl) {
        //System.out.println(dl[0]);
        //System.out.println(dl[1]);
        dn = new dangNhap(dl);
        System.out.println(dn.kq);
        phancap();
    }
    public String getKQ(){
        return dn.kq;
    }
    public String getTB(){
        return this.tb;
    }
    private void phancap(){
        
        if(dn.getlop()==1){
            this.tb+="Chào bạn "+dn.getTen()+" bạn đang đăng nhập với tư cách giáo viên";
            new giaoDienChinhChoGiaoVien().setVisible(true);
            
        }
        if(dn.getlop()==2){
            this.tb+="Chào bạn "+dn.getTen();
        }
        
    }
    
}
