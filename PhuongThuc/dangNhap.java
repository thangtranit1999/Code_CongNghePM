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
    private String user,pass,TF,ten;
    public String kq;
    int lop;
    
    public dangNhap(String[] dl) {
        this.user=dl[0];
        this.pass=dl[1];
        this.TF=dl[2];
        System.out.println(TF);
        if(TF.equals("true")){
            System.out.println(" true nè");
        }
        else{
            System.out.println(" false nè");
        }
        //System.out.println(pass);
        kiemtraDN();
    }
    void setKq(String a){
        this.kq=a;
    }
    String getKq(){
        return this.kq;
    }
    public int getlop(){
        return this.lop;
    }
    public String getTen(){
        return this.ten;
    }
    boolean kiemTra(){
        if(TF.equals("true")){
            try {
            kn.ketNoi();
            String sql="SELECT * FROM taiKhoanGV where userName='"+user+"' and passWord='"+pass+"'";
            kn.stmt = kn.cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = kn.stmt.executeQuery(sql);
            if(rs.next()==true){
                ten=rs.getString("name");
                lop=rs.getInt("class");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
        }
        else{
            try {
            kn.ketNoi();
            String sql="SELECT * FROM taiKhoanSV where userName='"+user+"' and passWord='"+pass+"'";
            kn.stmt = kn.cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = kn.stmt.executeQuery(sql);
            if(rs.next()==true){
                ten=rs.getString("name");
                lop=rs.getInt("class");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
        }
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
