/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code_CongNghePM.PhuongThucHayDung;
import Code_CongNghePM.PhuongThuc.ketNoi;
import java.sql.ResultSet;
/**
 *
 * @author Tran Thang
 */
public class PhuongThuc {
    ketNoi kn = new ketNoi();
    String sql;
    String[] mangDL = new String[LaySoDong()];
    public int LaySoDong(){
        int dem = 0;
        try {
            kn.ketNoi();
            kn.stmt = kn.cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = kn.stmt.executeQuery(sql);
            while(rs.next()){
                dem=rs.getInt("so");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return dem;
    }
    public void layDL(String sql){
        this.sql=sql;
        try {
            kn.ketNoi();
            kn.stmt = kn.cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = kn.stmt.executeQuery(sql);
            while(rs.next()){
                
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
