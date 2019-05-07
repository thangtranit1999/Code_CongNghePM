/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code_CongNghePM.DieuKhien;
import Code_CongNghePM.PhuongThuc.dangNhap;

/**
 *
 * @author Tran Thang
 */
public class dkDangNhap {
    dangNhap dn;
    public dkDangNhap(String[] dl) {
        //System.out.println(dl[0]);
        //System.out.println(dl[1]);
        dn = new dangNhap(dl);
        System.out.println(dn.kq);
    }
    public String getKQ(){
        return dn.kq;
    }
    
    
}
