/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package quanlivemaybay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import quanlivemaybay.model.KhachHang;

/**
 *
 * @author FPT
 */
public class TkKH extends javax.swing.JInternalFrame {

    /**
     * Creates new form TkNhanVien
     */
    Connection con = null;
    Statement stmt = null;
    PreparedStatement st = null;

    ResultSet rs = null;
    String name = "sa";
    String pass = "123";
    String url = "jdbc:sqlserver://localhost:1433;database=quanlimaybay;integratedSecurity=false;trustServerCertificate=true";
//    DefaultTableModel tblmodel = null;
    List<KhachHang> list = new ArrayList<>();

    public TkKH() {

        initComponents();
//        setLocationRelativeTo(null);
        txtEmail.setEnabled(false);
        txtGioiTinh.setEnabled(false);
        txtNameKH.setEnabled(false);
        txtNumberPhone.setEnabled(false);
        TaiDuLieu();
    }

    public void TaiDuLieu() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, name, pass);
            // Create and execute an SQL statement that returns some data.
            String SQL = "  select MaKh, TenKH, SDT, Gioitinh, Email, TenDangnhap, MatKhau ,role from taikhoan";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            // Iterate through the data in the result set and display it.
            list.clear();
            while (rs.next()) {
                String maKH = rs.getString(1);
                String tenKH = rs.getString(2);
                String sDT = rs.getString(3);
                String gioiTinh = rs.getString(4);
                String email = rs.getString(5);
                String tenDangNhap = rs.getString(6);
                String matKH = rs.getString(7);
                String role = rs.getString(8);

                KhachHang kh = new KhachHang(maKH, tenKH, sDT, gioiTinh, email, tenDangNhap, matKH, role);
                list.add(kh);
            }
            con.close();
        } catch (Exception e) {
        }
    }

    public void Find() {
        int ix = -1;
        if (txtFind.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nhap ma so SV: ");
            txtFind.requestFocus();
            return;
        }
        for (KhachHang kh : list) {
            if (txtFind.getText().equals(kh.getMaKH())) {
                ix = list.indexOf(kh);
                showDetail(ix);
            }
        }
        if (ix == -1) {
            JOptionPane.showMessageDialog(this, "Khum tim thay kh");
             New();
            return;
//            System.out.println(""+list.get(0).getEmail());
        }

    }

    public void showDetail(int ix) {
        txtNameKH.setText(list.get(ix).getTenKH());
        txtEmail.setText(list.get(ix).getEmail());
        txtGioiTinh.setText(list.get(ix).getGioiTinh());
        txtNumberPhone.setText(list.get(ix).getsDT());
        txtFind.setText(list.get(ix).getMaKH());

    }

    public void New() {
        txtEmail.setText("");
        txtFind.setText("");
        txtGioiTinh.setText("");
        txtNameKH.setText("");
        txtNumberPhone.setText("");
    }

    public void Exit() {
        System.exit(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtFind = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jLabel_TenKhachHang = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel_TenKhachHang1 = new javax.swing.JLabel();
        jLabel_TenKhachHang2 = new javax.swing.JLabel();
        jLabel_TenKhachHang3 = new javax.swing.JLabel();
        cboGioiTinh = new javax.swing.JLabel();
        txtNameKH = new javax.swing.JTextField();
        txtNumberPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtGioiTinh = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm khách hàng "));

        btnFind.setText("Tìm kiếm");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        jLabel_TenKhachHang.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel_TenKhachHang.setText("Mã khách hàng:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel_TenKhachHang)
                .addGap(18, 18, 18)
                .addComponent(txtFind, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnFind)
                .addGap(80, 80, 80))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind)
                    .addComponent(jLabel_TenKhachHang))
                .addGap(37, 37, 37))
        );

        btnNew.setText("Mới");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel4.add(btnNew);

        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel4.add(btnExit);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));

        jLabel_TenKhachHang1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel_TenKhachHang1.setText("Tên khách hàng:");

        jLabel_TenKhachHang2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel_TenKhachHang2.setText("Số điện thoại:");

        jLabel_TenKhachHang3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel_TenKhachHang3.setText("Email:");

        cboGioiTinh.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cboGioiTinh.setText("Giới tính:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboGioiTinh)
                    .addComponent(jLabel_TenKhachHang3)
                    .addComponent(jLabel_TenKhachHang1)
                    .addComponent(jLabel_TenKhachHang2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNameKH)
                        .addComponent(txtNumberPhone)
                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_TenKhachHang1)
                    .addComponent(txtNameKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_TenKhachHang2)
                    .addComponent(txtNumberPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_TenKhachHang3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboGioiTinh)
                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 3, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tìm kiếm khách hàng ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 277, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 277, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        Find();
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        New();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        Exit();
    }//GEN-LAST:event_btnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNew;
    private javax.swing.JLabel cboGioiTinh;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_TenKhachHang;
    private javax.swing.JLabel jLabel_TenKhachHang1;
    private javax.swing.JLabel jLabel_TenKhachHang2;
    private javax.swing.JLabel jLabel_TenKhachHang3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtNameKH;
    private javax.swing.JTextField txtNumberPhone;
    // End of variables declaration//GEN-END:variables
}