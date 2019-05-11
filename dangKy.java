/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code_CongNghePM;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import Code_CongNghePM.DieuKhien.dkDangNhap;
import Code_CongNghePM.PhuongThuc.ketNoi;
import javax.swing.JOptionPane;
import Code_CongNghePM.PhuongThuc.ketNoi;
import java.util.Vector;
import Code_CongNghePM.DieuKhien.dkDangKy;
/**
 *
 * @author Tran Thang
 */
public class dangKy extends javax.swing.JFrame {

    /**
     * Creates new form dangKy
     */
    public dangKy() {
        initComponents();
        LoadKhoa();
    }
    ketNoi kn = new ketNoi();
    Vector dsKhoa;
    String[] dl=new String[8];
    dkDangKy dk;
    private void LoadKhoa()
    {
        try
        {
            kn.ketNoi();
            String sql="select tenTinh from tinhThanh";
            ResultSet rs = kn.stmt.executeQuery(sql);
            dsKhoa=new Vector();
            cbQueQuan.removeAllItems();      
            while(rs.next())
            {
               Object o1 = rs.getObject(1);//mada
                dsKhoa.addElement(o1);
                
                Object o2 = rs.getObject(1);//tenda
                cbQueQuan.addItem(o2);
            }
            kn.ngatketnoi();
        }
        catch(Exception ex)
        {
            System.out.println("Lỗi load dữ liệu: "+ ex.toString());
        }
    }
    public boolean TraUser() {
        //
        //String a="";
        try {
            kn.ketNoi();
            String sql="select username from taiKhoan where username='"+txtUsername.getText()+"';";
            kn.stmt = kn.cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = kn.stmt.executeQuery(sql);
            if(rs.next()==true)
                return true;
            /*while(rs.next()){
                a+=rs.getString("username");   
            }*/
            
            kn.ngatketnoi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
        return false;
        /*if(a.length()==0){
            return true;
        }
        return false;*/

    }
    private void nhaplai() {
        txtNgaySinh.setText("");
        txtHoTen.setText("");
        txtEmail.setText("");
        txtDienThoai.setText("");
        rbNam.setSelected(false);
        rbNu.setSelected(false);
        txtUsername.setText("");
        txtPass.setText("");
        txtnhaplai.setText("");
    }

    boolean checkEmail(String email){
        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern regex = Pattern.compile(emailPattern);
        Matcher matcher = regex.matcher(email);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }

    }
    boolean kiemtra() {
        String err = "";
        if (txtHoTen.getText().equals("")) {
            err += "bạn chưa điền họ tên\n";
        }
        if (rbNam.isSelected() == false && rbNu.isSelected() == false) {
            err += "ban chưa chọ giới tính\n";
        }
        if (txtEmail.getText().equals(""))
                err += "bạn chưa điên email\n";
        else{
            if(checkEmail(txtEmail.getText())==false)
                err+="Email khong hop le\n";
        }
        try {
            Long.parseLong(txtDienThoai.getText());
            if(txtDienThoai.getText().length()<10||txtDienThoai.getText().length()>11){
                err+="Số điện thoại không hợp lệ\n";
            }

        } catch (Exception e) {
            err+="số bạn nhập không phải dạng số\n";
        }
        if (txtUsername.getText().equals("")) {
            err += "bạn chưa điền ten dang nhap\n";
        }
        if (txtPass.getPassword().equals("")) {
            err += "bạn chưa mat khau\n";
        }
        if (!txtnhaplai.getText().equals(txtPass.getText())) {
            err += "mật khẩu không khớp\n";
        }
        try {
            Date ns = Date.valueOf(txtNgaySinh.getText());
        } catch (Exception e) {
            err+="ngay sinh khong dung\n";
        }
        if(txtUsername.getText().length()==0){
            err+="Bạn phải điền tên đăng nhập\n";
        }
        else{
            if(TraUser()==true){
            err+="ton tai ten dang nhap\n";
            }
        }
        
        if (err != "") {
            JOptionPane.showMessageDialog(this, err);
            return false;
        }
        return true;
    }

    /**
     * Creates new form formDangKy
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNgaySinh = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDienThoai = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnhaplai = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rbNam = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        rbNu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        btDangKy = new javax.swing.JButton();
        btNhapLai = new javax.swing.JButton();
        txtHoTen = new javax.swing.JTextField();
        btThoat = new javax.swing.JButton();
        cbQueQuan = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("UserName");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("Password");

        txtDienThoai.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txtPass.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Họ Tên");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Giới Tính");

        txtnhaplai.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtnhaplai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnhaplaiActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Ngày sinh");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Email");

        rbNam.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rbNam.setText("Nam");
        rbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNamActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Điện Thoại");

        rbNu.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rbNu.setText("Nữ");
        rbNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNuActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Quê Quán");

        btDangKy.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btDangKy.setText("Lưu CSDL");
        btDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDangKyActionPerformed(evt);
            }
        });

        btNhapLai.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btNhapLai.setText("Nhập lại");
        btNhapLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhapLaiActionPerformed(evt);
            }
        });

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btThoat.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btThoat.setText("Thoát");
        btThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoatActionPerformed(evt);
            }
        });

        cbQueQuan.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbQueQuan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 172, Short.MAX_VALUE)
                        .addComponent(btDangKy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btNhapLai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btThoat)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbNu))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDienThoai, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(cbQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnhaplai)
                            .addComponent(txtPass)
                            .addComponent(txtUsername))
                        .addGap(77, 77, 77))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rbNam)
                    .addComponent(rbNu))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtnhaplai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDangKy)
                    .addComponent(btNhapLai)
                    .addComponent(btThoat))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnhaplaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnhaplaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnhaplaiActionPerformed

    private void rbNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNamActionPerformed

    private void rbNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNuActionPerformed

    private void btDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDangKyActionPerformed
        if(kiemtra()==true){
            dl[0]=txtHoTen.getText();
        dl[1]=String.valueOf(rbNu.isSelected());
        dl[2]=txtNgaySinh.getText();
        dl[3]=txtEmail.getText();
        dl[4]=txtDienThoai.getText();
        dl[5]=dsKhoa.get(cbQueQuan.getSelectedIndex()).toString();
        dl[6]=txtUsername.getText();
        dl[7]=txtPass.getText();
        dkDangKy dk = new dkDangKy(dl);
        JOptionPane.showMessageDialog(this, dk.getKQ());
        }
    }//GEN-LAST:event_btDangKyActionPerformed

    private void btNhapLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhapLaiActionPerformed
        // TODO add your handling code here:
        nhaplai();
    }//GEN-LAST:event_btNhapLaiActionPerformed

    private void btThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThoatActionPerformed
        // TODO add your handling code here:
        int kq = JOptionPane.showConfirmDialog(this, "Ban co muon thoat?");
        if (kq == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btThoatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dangKy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDangKy;
    private javax.swing.JButton btNhapLai;
    private javax.swing.JButton btThoat;
    private javax.swing.JComboBox cbQueQuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rbNam;
    private javax.swing.JRadioButton rbNu;
    private javax.swing.JTextField txtDienThoai;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPasswordField txtnhaplai;
    // End of variables declaration//GEN-END:variables
}
