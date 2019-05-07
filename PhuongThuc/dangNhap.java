/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code_CongNghePM.PhuongThuc;

import java.sql.ResultSet;

/**
 *
 * @author Tran Thang
 */
public class dangNhap {
    ketNoi kn = new ketNoi();
    private String user,pass;
    public String kq;
    public dangNhap(String[] dl) {
        this.user=dl[0];
        this.pass=dl[1];
        //System.out.println(user);
        //System.out.println(pass);
        kiemtraDN();
    }
    void setKq(String a){
        this.kq=a;
    }
    String getKq(){
        return this.kq;
    }
    boolean kiemTra(){
        try {
            kn.ketNoi();
            String sql="SELECT * FROM taiKhoan where userName='"+user+"' and passWord='"+pass+"'";
            kn.stmt = kn.cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = kn.stmt.executeQuery(sql);
            if(rs.next()==true){
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
    void kiemtraDN(){
        if(kiemTra()==true){
            this.setKq("Bạn đã đăng nhập thành công");
        }
        else{
            this.setKq("Sai tên đang nhập");
        }
    }
    
    
}
