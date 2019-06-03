/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code_CongNghePM;
import javax.swing.JOptionPane;
import Code_CongNghePM.PhuongThuc.ketNoi;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Tran Thang
 */
public class thongKe extends javax.swing.JFrame {

    /**
     * Creates new form thongKe
     */
    String ten;
    public thongKe(String ten) {
        this.ten=ten;
        TraUser();
        initComponents();
        loadData();
        load();
        loadTenKhoa();
        testOne();
        //loadTable();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    void testOne(){
        //System.out.println(a);
        for(int i=0; i<a; i++){
            //System.out.println(sbd[i]+"\t"+Toan[i]+"\t"+Van[i]+"\t"+Anh[i]);
            int toan,van,anh,tb;
            toan=Integer.parseInt(Toan[i]);
            van=Integer.parseInt(Van[i]);
            anh=Integer.parseInt(Anh[i]);
            tb=(toan+van+anh)/3;
            //System.out.println(toan+anh+van);
            if(tb>=7){
                dem1++;
            }
            else{
                dem2++;
            }
        }
        
        lb2.setText("Điểm trung bình trên 7: "+String.valueOf(dem1));
        lb3.setText("Điểm trung bình dưới 7: "+String.valueOf(dem2));
    }
    public void TraUser() {
        //
        
        int i=0;
        try {
            kn.ketNoi();
            String sql="select * from diemSV";
            kn.stmt = kn.cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = kn.stmt.executeQuery(sql);
            while(rs.next()){
                rs.getRow();
                sbd[i]=rs.getString("SBD");
                Toan[i]=rs.getString("Toan");
                Van[i]=rs.getString("Van");
                Anh[i]=rs.getString("Anh");
                i++;
            }
            
            a=rs.getRow()-1;
            kn.ngatketnoi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
        

    }
    void loadTenKhoa(){
        try {
            kn.ketNoi();
            String sql="SELECT *\n" +
"FROM nganh;";
            ResultSet rs = kn.stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            columnName = new Vector();
            int n=rsmd.getColumnCount();
            for(int i=1; i<=n; i++){
                columnName.addElement(rsmd.getColumnName(i));
            }
            model = new DefaultTableModel();
            model.setColumnIdentifiers(columnName);
            while(rs.next()){
                Vector  data = new Vector();
                for(int i=1; i<=n; i++){
                    Object o = rs.getObject(i);
                    data.addElement(o);
                }
                model.addRow(data);
            }
            tbTenKhoa.removeAll();
            tbTenKhoa.setModel(model);
            kn.ngatketnoi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
            e.printStackTrace();
        }
    }
    void load(){
        try {
            kn.ketNoi();
            String sql="SELECT hoTen as 'Họ Tên',Sum(toan+van+anh)/3 AS 'Điểm trung binh'\n" +
"FROM diemSV INNER JOIN sinhVien ON diemSV.SBD = sinhVien.SBD\n" +
"WHERE (((sinhVien.SBD)=[diemSV].[SBD]))\n" +
"GROUP BY sinhVien.hoTen;";
            ResultSet rs = kn.stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            columnName = new Vector();
            int n=rsmd.getColumnCount();
            for(int i=1; i<=n; i++){
                columnName.addElement(rsmd.getColumnName(i));
            }
            model = new DefaultTableModel();
            model.setColumnIdentifiers(columnName);
            while(rs.next()){
                Vector  data = new Vector();
                for(int i=1; i<=n; i++){
                    Object o = rs.getObject(i);
                    data.addElement(o);
                }
                model.addRow(data);
            }
            tbDiemTB.removeAll();
            tbDiemTB.setModel(model);
            kn.ngatketnoi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
            e.printStackTrace();
        }
    }
    private void loadData(){
        try {
            kn.ketNoi();
            String sql="SELECT tenNganh as 'Tên Ngành',count(sinhVien.nganh) as 'Số Lượng Sinh Viên'\n" +
"FROM nganh INNER JOIN sinhVien ON nganh.maNganh = sinhVien.nganh\n" +
"WHERE (((nganh.maNganh)=[sinhVien].[nganh]))\n" +
"group by tenNganh";
            ResultSet rs = kn.stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            columnName = new Vector();
            int n=rsmd.getColumnCount();
            for(int i=1; i<=n; i++){
                columnName.addElement(rsmd.getColumnName(i));
            }
            model = new DefaultTableModel();
            model.setColumnIdentifiers(columnName);
            while(rs.next()){
                Vector  data = new Vector();
                for(int i=1; i<=n; i++){
                    Object o = rs.getObject(i);
                    data.addElement(o);
                }
                model.addRow(data);
            }
            tb.removeAll();
            tb.setModel(model);
            kn.ngatketnoi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbTenKhoa = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbDiemTB = new javax.swing.JTable();
        lb1 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tb);

        tbTenKhoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tbTenKhoa);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Số lượng", jPanel2);

        tbDiemTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tbDiemTB);

        lb1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lb3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb3.setForeground(new java.awt.Color(51, 51, 255));
        lb3.setText("jLabel1");

        lb2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb2.setForeground(new java.awt.Color(255, 51, 51));
        lb2.setText("jLabel2");

        jButton1.setText("Xem danh sách");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Xem danh sách");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lb3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lb2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(lb1)
                .addContainerGap(258, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb2)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb3)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Điểm trung bình", jPanel3);

        jButton3.setText("Trở về");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(793, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(449, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            kn.ketNoi();
            String sql="SELECT sinhVien.hoTen, DTB as 'Điểm trung bình'\n" +
            "FROM sinhVien INNER JOIN diemTrungBinh ON sinhVien.hoTen = diemTrungBinh.hoTen\n" +
            "WHERE (((sinhVien.hoTen)=[diemTrungBinh].[hoTen])) and DTB>=7";
            ResultSet rs = kn.stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            columnName = new Vector();
            int n=rsmd.getColumnCount();
            for(int i=1; i<=n; i++){
                columnName.addElement(rsmd.getColumnName(i));
            }
            model = new DefaultTableModel();
            model.setColumnIdentifiers(columnName);
            while(rs.next()){
                Vector  data = new Vector();
                for(int i=1; i<=n; i++){
                    Object o = rs.getObject(i);
                    data.addElement(o);
                }
                model.addRow(data);
            }
            tbDiemTB.removeAll();
            tbDiemTB.setModel(model);
            kn.ngatketnoi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            kn.ketNoi();
            String sql="SELECT sinhVien.hoTen, DTB as 'Điểm trung bình'\n" +
            "FROM sinhVien INNER JOIN diemTrungBinh ON sinhVien.hoTen = diemTrungBinh.hoTen\n" +
            "WHERE (((sinhVien.hoTen)=[diemTrungBinh].[hoTen])) and DTB<7";
            ResultSet rs = kn.stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            columnName = new Vector();
            int n=rsmd.getColumnCount();
            for(int i=1; i<=n; i++){
                columnName.addElement(rsmd.getColumnName(i));
            }
            model = new DefaultTableModel();
            model.setColumnIdentifiers(columnName);
            while(rs.next()){
                Vector  data = new Vector();
                for(int i=1; i<=n; i++){
                    Object o = rs.getObject(i);
                    data.addElement(o);
                }
                model.addRow(data);
            }
            tbDiemTB.removeAll();
            tbDiemTB.setModel(model);
            kn.ngatketnoi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new homeGV(ten).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    ketNoi kn = new ketNoi();
    private ResultSet rs;
    Vector columnName;
    DefaultTableModel model;
    int a;
    String[] sbd = new String[100];
    String[] Toan = new String[100];
    String[] Van = new String[100];
    String[] Anh = new String[100];
    int dem1=0,dem2=0;
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
            java.util.logging.Logger.getLogger(thongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(thongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(thongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(thongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new thongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JTable tb;
    private javax.swing.JTable tbDiemTB;
    private javax.swing.JTable tbTenKhoa;
    // End of variables declaration//GEN-END:variables
}
