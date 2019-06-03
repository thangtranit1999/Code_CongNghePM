/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code_CongNghePM;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Code_CongNghePM.PhuongThucHayDung.Student;
import Code_CongNghePM.PhuongThucHayDung.dayDuLieuSinhVien;
import javax.swing.JOptionPane;
import Code_CongNghePM.PhuongThucHayDung.themSuaXoa;

/**
 *
 * @author Tran Thang
 */
public class giaoDienChinhChoGiaoVien extends javax.swing.JFrame {

    /**
     * Creates new form giaoDienChinhChoGiaoVien
     */
    int i=0;
    String ten;
    private ArrayList<Student> list;
    DefaultTableModel model;
    dayDuLieuSinhVien dl= new dayDuLieuSinhVien();
    public giaoDienChinhChoGiaoVien(String ten) {
        initComponents();
        //lammoi();
        this.ten = ten;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        list = dl.getListStudent();
        model = (DefaultTableModel) jTable1.getModel();
        model.setColumnIdentifiers(new Object[]{
            "STT", "Số Báo danh", "Họ Tên", "Giới Tính", "Ngày Sinh", "Email", "Điện Thoại", "Quê Quán","Ngành học","UserName"
        });
        
        showTable();
    }
    public void lammoi(){
        this.setLocationRelativeTo(null);
        list = dl.getListStudent();
        model = (DefaultTableModel) jTable1.getModel();
        model.setColumnIdentifiers(new Object[]{
            "STT", "Số Báo danh", "Họ Tên", "Giới Tính", "Ngày Sinh", "Email", "Điện Thoại", "Quê Quán","UserName"
        });
        
        //showTable();// hien thi thong tin trong danh sach
    }
    public void showTable() {
        for (Student s : list) {
            model.addRow(new Object[]{
                i++, s.getSBD(), s.getHoTen(), s.getGioiTinh(), s.getNgaySinh(), s.getEmail(), s.getDienThoai(), s.getQueQuan(),s.getNganh(),s.getuser()
                
            });
        }
    }
    
    public void showResult() {
        Student s = list.get(list.size() - 1);
        model.addRow(new Object[]{
            i++, s.getSBD(), s.getHoTen(), s.getGioiTinh(), s.getNgaySinh(), s.getEmail(), s.getDienThoai(), s.getQueQuan(),s.getuser()
        });
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Sửa thông tin sinh viên");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Xóa thông tin sinh viên");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Thêm thông tin sinh viên");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Trở lai");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Làm mới");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jButton6.setText("Tìm kiếm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(79, 475, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(jButton3)
                                .addComponent(jButton2)))
                        .addComponent(jButton5)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int a= jTable1.getSelectedRow();
        System.out.print(a);
        if(a==-1){
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một dòng");
            return;
        }
        String[] dulieu  = new String[jTable1.getColumnCount()];
        for(int i=0; i<jTable1.getColumnCount(); i++){
            
            dulieu[i] = jTable1.getValueAt(a, i).toString();
        }
        System.out.println(jTable1.getSelectedRow());
        new dangKy(dulieu).setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        if(i==-1){
            JOptionPane.showMessageDialog(this, "Bạn vui lòng chọn dòng để xóa");
            return;
        }
        int ok = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa thí sinh "+jTable1.getValueAt(i, 2));
        if(ok == JOptionPane.YES_OPTION){
            String sql1="delete from sinhVien where SBD='"+jTable1.getValueAt(i, 1)+"';";
            String sql2="delete from diemSV where SBD='"+jTable1.getValueAt(i, 1)+"';";
            String sql3="delete from taiKhoanSV where SBD='"+jTable1.getValueAt(i, 1)+"';";
            themSuaXoa x = new themSuaXoa(sql1,sql2,sql3);
            JOptionPane.showConfirmDialog(this, x.getChuoi());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new dangKy().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        showResult();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        homeGV h = new homeGV(ten);
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        /*for(int i = 0; i < jTable1.getRowCount(); i++){//For each row
        for(int j = 0; j < jTable1.getColumnCount(); j++){//For each column in that row
            if(jTable1.getModel().getValueAt(i, j).equals("0965198994")){//Search the model
                System.out.println(jTable1.getModel().getValueAt(i, 1));//Print if found string

        
                //for (Student s : list) {
                    model.addRow(new Object[]{
                    jTable1.getModel().getValueAt(i, 0),
                    jTable1.getModel().getValueAt(i, 1),
                    jTable1.getModel().getValueAt(i, 2),
                    jTable1.getModel().getValueAt(i, 3),
                    jTable1.getModel().getValueAt(i, 4),
                    jTable1.getModel().getValueAt(i, 5),
                    jTable1.getModel().getValueAt(i, 6),
                    jTable1.getModel().getValueAt(i, 7),
                    jTable1.getModel().getValueAt(i, 8),
                    jTable1.getModel().getValueAt(i, 9)
                });
                    //}
                    break;
            }
            
        }//For loop inner
    }//For loop outer*/
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(giaoDienChinhChoGiaoVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(giaoDienChinhChoGiaoVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(giaoDienChinhChoGiaoVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(giaoDienChinhChoGiaoVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new giaoDienChinhChoGiaoVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
