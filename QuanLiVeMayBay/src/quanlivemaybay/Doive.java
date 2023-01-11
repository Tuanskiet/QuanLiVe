/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlivemaybay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import quanlivemaybay.helper.DatabaseHelper;
import quanlivemaybay.helper.InsertData;
import quanlivemaybay.model.Controler;
import quanlivemaybay.model.Datvemain;

/**
 *
 * @author ADMIN
 */
public class Doive extends javax.swing.JFrame {

    DefaultTableModel dtmVe;
    ArrayList<Datvemain> dv = new ArrayList<>();
    String Makh;
    String maveht = "";
    JFrame jframe;

    /**
     * Creates new form Doive
     */
    public Doive() {
        initComponents();
        setTitle("Đổi vé");
        jdcNgayBay.setDate(new Date(System.currentTimeMillis()));
        InsertData.LoadDataVe();
        setLocationRelativeTo(null);
        loadTable();
        loadComboBox();

    }

    public Doive(String MAkh, String Mave, JFrame jf) {
        this.Makh = MAkh;
        this.jframe = jf;
        initComponents();
        jdcNgayBay.setDate(new Date(System.currentTimeMillis()));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        InsertData.LoadDataVe();
        InsertData.LoadDataDatVe(Makh);
        setLocationRelativeTo(null);
        loadTable();
        loadComboBox();
//        if (Mave.equals("")) {
//            JOptionPane.showMessageDialog(this, "Ban chua nhap ve!");
//            return;
//        }
        this.maveht = Mave;
    }

    public void loadComboBox() {
        for (VeMayBay ve : Controler.arrayListVe) {
            cboDiemDi.addItem(ve.getDiemdi());
            cboDiemDen.addItem(ve.getDiemden());
        }

    }

    public void loadTable() {
        dtmVe = (DefaultTableModel) tblVe.getModel();
        while (dtmVe.getRowCount() > 0) {
            dtmVe.removeRow(0);
        }

        for (VeMayBay ve : Controler.arrayListVe) {
            dtmVe.addRow(new Object[]{ve.getMaVe(), ve.getDiemdi(),
                ve.getDiemden(), ve.getLoaiVe(), ve.getGioBay(), ve.getNgayBay(),
                ve.getNgayBan(), ve.getGiaVe()});
        }
        dtmVe.fireTableDataChanged();
    }
    
    public static void loadTablee(){
        DefaultTableModel tblmodelVeCuaToi = (DefaultTableModel) UserPage.tblVeCuaToi.getModel();


        while (tblmodelVeCuaToi.getRowCount() > 0) {
            tblmodelVeCuaToi.removeRow(0);
        }

        for (Datvemain ve : Controler.arrayListDatVe) {
            tblmodelVeCuaToi.addRow(new Object[]{ve.getMaVe(), ve.getNgayDat(), ve.getGioDat()});
        }

        tblmodelVeCuaToi.fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboDiemDi = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cboDiemDen = new javax.swing.JComboBox();
        jdcNgayBay = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVe = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Điểm đi:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Ngày bay : ");

        cboDiemDi.setBackground(new java.awt.Color(153, 153, 153));
        cboDiemDi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDiemDiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Điểm đến:");

        cboDiemDen.setBackground(new java.awt.Color(153, 153, 153));

        jdcNgayBay.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboDiemDi, 0, 175, Short.MAX_VALUE)
                    .addComponent(jdcNgayBay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(101, 101, 101)
                .addComponent(cboDiemDen, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboDiemDi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cboDiemDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcNgayBay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(0, 28, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        jButton2.setText("TÌm kiếm ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 153, 153));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rsz_exit.png"))); // NOI18N
        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tblVe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã vé", "Điểm đi", "Điểm đến", "Loại vé", "Giờ bay", "Ngày bay", "Ngày bán", "Giá vé"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVe);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(309, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jButton3)
                        .addGap(258, 258, 258))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 911, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 23, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 23, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Connection con = DatabaseHelper.openConnection();
            String sql = "select * from Ve where Diemdi = ? and Diemden = ? and NgayBay =?";
            PreparedStatement st = con.prepareStatement(sql);
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            Date ngayBay = jdcNgayBay.getDate();

            st.setString(1, cboDiemDi.getSelectedItem().toString());
            st.setString(2, cboDiemDen.getSelectedItem().toString());
            st.setString(3, formater.format(ngayBay));
            ResultSet rs = st.executeQuery();
            dtmVe.setRowCount(0);
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
                row.add(String.valueOf(rs.getDate(6)));
                row.add(String.valueOf(rs.getDate(7)));
                row.add(rs.getFloat(8));
                dtmVe.addRow(row);
            }

            tblVe.setModel(dtmVe);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        loadTablee();

        jframe.setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void cboDiemDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDiemDiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboDiemDiActionPerformed

    private void tblVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVeMouseClicked
        // TODO add your handling code here:

        int row = tblVe.getSelectedRow();
        String mavedoi = tblVe.getValueAt(row, 0).toString();
        boolean flag = false;
        String mes = "Bạn có muốn đổi vé " + maveht + " sang vé " + mavedoi + " không?";
        if (row >= 0) {
            int log = JOptionPane.showConfirmDialog(null, mes, "WARNING", JOptionPane.YES_NO_OPTION);
            if (log == JOptionPane.YES_OPTION) {

                for (Datvemain ve : Controler.arrayListDatVe) {
                    if (mavedoi.equals(ve.getMaVe())) {
                        JOptionPane.showMessageDialog(null, "Bạn đã đặt vé này rồi!");
                        flag = true;
                        return;
                    }
                }
                if (flag == false) {
                    try {
                        InsertData.updateDatVe(mavedoi, Makh, maveht);
                        InsertData.LoadDataDatVe(Makh);
                    } catch (Exception ex) {
//                    Logger.getLogger(UserPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }
    }//GEN-LAST:event_tblVeMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
        loadTablee();
        jframe.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Doive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Doive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Doive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Doive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Doive().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboDiemDen;
    private javax.swing.JComboBox cboDiemDi;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcNgayBay;
    private javax.swing.JTable tblVe;
    // End of variables declaration//GEN-END:variables
}
