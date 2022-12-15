/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package quanlivemaybay;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlivemaybay.helper.DatabaseHelper;
import quanlivemaybay.helper.InsertData;
import quanlivemaybay.model.Controler;

/**
 *
 * @author FPT
 */
public class BanVeMB extends javax.swing.JInternalFrame {

    /**
     * Creates new form BanVeMB
     */
    public BanVeMB() {
        initComponents();
        setTitle("Bán vé máy bay");
        autoID();
        jdcNgayBay.setDate(new Date(System.currentTimeMillis()));
        jdcNgayBan.setDate(new Date(System.currentTimeMillis()));

    }

    public void autoID() {
        try {
            java.sql.Connection con = DatabaseHelper.openConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select MAX(MaVe) from Ve");
            rs.next();
            rs.getString(1);
            if (rs.getString(1) == null) {
                txtMaVe.setText("VS001");
            } else {
                long id = Long.parseLong(rs.getString(1).substring(2, rs.getString(1).length()));
                id++;
                txtMaVe.setText("VS" + String.format("%03d", id));

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DangKi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DangKi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BanVeMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void resetForm() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grLoaiVe = new javax.swing.ButtonGroup();
        jPanel11 = new javax.swing.JPanel();
        btnBanVe = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtDiemDi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtDiemDen = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMaVe = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        rdoThuongGia = new javax.swing.JRadioButton();
        rdoPhoThong = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtGiaVe = new javax.swing.JTextField();
        jdcNgayBay = new com.toedter.calendar.JDateChooser();
        jdcNgayBan = new com.toedter.calendar.JDateChooser();
        txtgiobay = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(900, 568));

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5));

        btnBanVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rsz_ticket-machine.png"))); // NOI18N
        btnBanVe.setText("Bán Vé");
        btnBanVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanVeActionPerformed(evt);
            }
        });
        jPanel11.add(btnBanVe);

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rsz_exit.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        jPanel11.add(btnThoat);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("Chương trình bán vé máy bay Poly Ariline");
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thong tin can nhap"));
        jPanel2.setLayout(null);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thong tin ve va chuyen bay"));

        jPanel5.setLayout(new java.awt.GridLayout(1, 4, 20, 20));

        jLabel13.setText("Điểm đi:");
        jPanel5.add(jLabel13);
        jPanel5.add(txtDiemDi);

        jLabel12.setText("Diem den:");
        jPanel5.add(jLabel12);
        jPanel5.add(txtDiemDen);

        jPanel6.setLayout(null);

        jLabel3.setText("Mã vé:");
        jPanel6.add(jLabel3);
        jLabel3.setBounds(0, 0, 90, 36);

        txtMaVe.setEditable(false);
        jPanel6.add(txtMaVe);
        txtMaVe.setBounds(200, 0, 170, 36);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Loai ve"));
        jPanel7.setLayout(new java.awt.GridLayout(1, 2, 20, 20));

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setLayout(new java.awt.GridLayout(1, 2, 20, 16));

        grLoaiVe.add(rdoThuongGia);
        rdoThuongGia.setText("Thuong gia");
        jPanel8.add(rdoThuongGia);

        grLoaiVe.add(rdoPhoThong);
        rdoPhoThong.setSelected(true);
        rdoPhoThong.setText("Pho thong");
        jPanel8.add(rdoPhoThong);

        jPanel7.add(jPanel8);

        jPanel10.setLayout(null);

        jLabel17.setText("Giờ bay:");
        jPanel10.add(jLabel17);
        jLabel17.setBounds(0, 70, 176, 29);

        jLabel18.setText("Ngày bay:");
        jPanel10.add(jLabel18);
        jLabel18.setBounds(0, 10, 176, 29);

        jLabel15.setText("Ngày bán:");
        jPanel10.add(jLabel15);
        jLabel15.setBounds(390, 10, 170, 29);

        jLabel19.setText("Giá vé:");
        jPanel10.add(jLabel19);
        jLabel19.setBounds(390, 70, 170, 29);
        jPanel10.add(txtGiaVe);
        txtGiaVe.setBounds(590, 70, 170, 29);

        jdcNgayBay.setDateFormatString("yyyy-MM-dd");
        jPanel10.add(jdcNgayBay);
        jdcNgayBay.setBounds(200, 10, 170, 30);

        jdcNgayBan.setDateFormatString("yyyy-MM-dd");
        jPanel10.add(jdcNgayBan);
        jdcNgayBan.setBounds(590, 10, 170, 30);
        jPanel10.add(txtgiobay);
        txtgiobay.setBounds(200, 70, 170, 30);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel7.getAccessibleContext().setAccessibleName("Loại vé");

        jPanel2.add(jPanel4);
        jPanel4.setBounds(40, 30, 800, 330);
        jPanel4.getAccessibleContext().setAccessibleName("Thông tin vé và chuyến bay");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 106, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel2.getAccessibleContext().setAccessibleName("Thông tin cần nhập");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBanVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanVeActionPerformed

        String maVe = txtMaVe.getText();
        String diemDi = txtDiemDi.getText();
        String diemDen = txtDiemDen.getText();
        String loaiVe = "";
        if (rdoPhoThong.isSelected()) {
            loaiVe = "Thuong Gia";
        } else {
            loaiVe = "Pho Thong";
        }
        String gioBay = txtgiobay.getText();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        Date ngayBay = jdcNgayBay.getDate();
        Date ngayBan = jdcNgayBan.getDate();
        float giaVe = Float.parseFloat(txtGiaVe.getText());
        VeMayBay ve = new VeMayBay(maVe, diemDi, diemDen, loaiVe, gioBay, formater.format(ngayBay), formater.format(ngayBan), giaVe);

        InsertData.insertVe(ve);
        Controler.arrayListVe.add(ve);
        resetForm();


    }//GEN-LAST:event_btnBanVeActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.hide();
    }//GEN-LAST:event_btnThoatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanVe;
    private javax.swing.JButton btnThoat;
    private javax.swing.ButtonGroup grLoaiVe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private com.toedter.calendar.JDateChooser jdcNgayBan;
    private com.toedter.calendar.JDateChooser jdcNgayBay;
    private javax.swing.JRadioButton rdoPhoThong;
    private javax.swing.JRadioButton rdoThuongGia;
    private javax.swing.JTextField txtDiemDen;
    private javax.swing.JTextField txtDiemDi;
    private javax.swing.JTextField txtGiaVe;
    private javax.swing.JTextField txtMaVe;
    private javax.swing.JTextField txtgiobay;
    // End of variables declaration//GEN-END:variables
}
