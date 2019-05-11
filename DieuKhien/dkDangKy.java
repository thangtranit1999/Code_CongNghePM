/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code_CongNghePM.DieuKhien;
import Code_CongNghePM.PhuongThuc.ptDangKy;
/**
 *
 * @author Tran Thang
 */
public class dkDangKy {
    ptDangKy dk;
    public dkDangKy(String[] dl) {
        dk = new ptDangKy(dl);
        for(int i=0; i<8;i++){
            System.out.println(dl[i]+"\n");
        }
    }
    public boolean getbool(){
        return dk.traUser();
    }
    public String getKQ(){
        return dk.getChuoi();
    }
    
}
