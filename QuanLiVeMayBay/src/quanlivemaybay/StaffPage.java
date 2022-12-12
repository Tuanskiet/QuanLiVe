/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlivemaybay;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import quanlivemaybay.helper.DatabaseHelper;
import quanlivemaybay.helper.InsertData;
import quanlivemaybay.model.Controler;
import quanlivemaybay.model.User;

/**
 *
 * @author FPT
 */
public class StaffPage extends javax.swing.JFrame {

    String user = "sa";
    String pass = "123";
    String url = "jdbc:sqlserver://localhost;database=quanlimaybay";
    Connection con;
    PreparedStatement pst;
    DefaultTableModel tblModel;
    private String MaNV = "";
    List<User> list = new ArrayList<>();
    String tenNV;
    int index = 0;
    DefaultTableModel dtmNhanVien = null;
    boolean flag = false;

    /**
     * Creates new form StaffPage
     */
    public StaffPage() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        ss();

    }

    public void autoID() {

        try {
            con = DatabaseHelper.openConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select MAX(MaKh) from taikhoan");
            rs.next();
            rs.getString(1);
            if (rs.getString(1) == null) {
                txtMaNV.setText("KH001");
            } else {
                long id = Long.parseLong(rs.getString(1).substring(2, rs.getString(1).length()));
                id++;
                txtMaNV.setText("KH" + String.format("%03d", id));

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DangKi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(StaffPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public StaffPage1() {
//        initComponents();
//        ss();
//        
//    }
    public void ss() {
        jButton_QuayLai.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton_KhoiPhucMK.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton_SuaNhanVien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton_ThemNhanVien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton_XoaNhanVien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dtmNhanVien = (DefaultTableModel) jTable_NhanVien.getModel();
        dtmNhanVien.setColumnIdentifiers(new Object[]{
            "Mã NV", "Tên NV", "SĐT", "Email", "Giới tính", "User", "Pass", "Phân Quyền"
        });
        loadBangNhanVien();

        this.setLocationRelativeTo(null);
    }

    public void suaNV() throws ClassNotFoundException, SQLException {
//        try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(url, user, pass);
        String sql = "update taikhoan set TenKH = ?, SDT = ?, Gioitinh= ?, Email = ?, TenDangnhap = ?,"
                + "MatKhau = ?, role = ? where MaKh = ?";
        pst = con.prepareStatement(sql);
        pst.setString(1, txtTenNV.getText());
        pst.setString(2, txtSDT.getText());
        pst.setString(3, cboGT.getSelectedItem().toString());
        pst.setString(4, txtMail.getText());
        pst.setString(5, txtUser.getText());
        pst.setString(6, txtPass.getText());
        pst.setString(7, cboRole.getSelectedItem().toString());
        pst.setString(8, txtMaNV.getText());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "Update thành công!");
        InsertData.LoadDataNhanVien();
        con.close();
//        LoadDataToArray();

//        } catch (Exception e) {
//            System.out.println("e");
//            JOptionPane.showMessageDialog(this, "ERROR");
//        }
        loadBangNhanVien();
    }

    public void removeKH() throws ClassNotFoundException, SQLException {
//        try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(url, user, pass);
        String sql = "delete from taikhoan where Makh = ?";
        pst = con.prepareStatement(sql);
        pst.setString(1, txtMaNV.getText());
        pst.executeUpdate();
        index = jTable_NhanVien.getSelectedRow();
        if (index >= 0) {
            int choose = JOptionPane.showConfirmDialog(this, "Are you sure ?", "Comfirm", JOptionPane.YES_NO_OPTION);

            if (choose == JOptionPane.YES_OPTION) {

                Controler.arrayListTaiKhoan.remove(index);
                JOptionPane.showMessageDialog(this, "Đã xóa thành công!");
            } else {
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn NV/KH cần xóa!");
        }
        con.close();
        loadBangNhanVien();
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
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_NhanVien = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jButton_QuayLai = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        jButton_ThemNhanVien = new javax.swing.JButton();
        jButton_XoaNhanVien = new javax.swing.JButton();
        jButton_SuaNhanVien = new javax.swing.JButton();
        jLabel_BaoLoi = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton_KhoiPhucMK = new javax.swing.JButton();
        cboGT = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cboRole = new javax.swing.JComboBox<>();
        btnFind = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rsz_ticket.png"))); // NOI18N
        jButton1.setText("Bán vé");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rsz_ticket-machine.png"))); // NOI18N
        jButton2.setText("Kiểm tra vé");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(0, 373));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lí vé", jPanel2);

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel6MousePressed(evt);
            }
        });

        jTable_NhanVien.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable_NhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jTable_NhanVien.setRowHeight(25);
        jTable_NhanVien.setRowMargin(2);
        jTable_NhanVien.setSelectionBackground(new java.awt.Color(255, 77, 77));
        jTable_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_NhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_NhanVien);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setText("Danh Sách NV/KH");

        jButton_QuayLai.setBackground(new java.awt.Color(0, 102, 102));
        jButton_QuayLai.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jButton_QuayLai.setForeground(new java.awt.Color(255, 255, 255));
        jButton_QuayLai.setText("Quay Lại");
        jButton_QuayLai.setBorderPainted(false);
        jButton_QuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_QuayLaiActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel9.setText("Thông tin cơ bản của nhân viên");

        txtFind.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFindFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFindFocusLost(evt);
            }
        });
        txtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindActionPerformed(evt);
            }
        });
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindKeyReleased(evt);
            }
        });

        jButton_ThemNhanVien.setBackground(new java.awt.Color(255, 121, 63));
        jButton_ThemNhanVien.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jButton_ThemNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ThemNhanVien.setText("Thêm mới");
        jButton_ThemNhanVien.setBorderPainted(false);
        jButton_ThemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemNhanVienActionPerformed(evt);
            }
        });

        jButton_XoaNhanVien.setBackground(java.awt.Color.red);
        jButton_XoaNhanVien.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jButton_XoaNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        jButton_XoaNhanVien.setText("Xóa ");
        jButton_XoaNhanVien.setBorderPainted(false);
        jButton_XoaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaNhanVienActionPerformed(evt);
            }
        });

        jButton_SuaNhanVien.setBackground(new java.awt.Color(60, 60, 153));
        jButton_SuaNhanVien.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jButton_SuaNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        jButton_SuaNhanVien.setText("Sửa ");
        jButton_SuaNhanVien.setBorderPainted(false);
        jButton_SuaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SuaNhanVienActionPerformed(evt);
            }
        });

        jLabel_BaoLoi.setForeground(new java.awt.Color(255, 255, 51));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel10.setText("| Tìm theo Mã NV/KH");

        jButton_KhoiPhucMK.setBackground(new java.awt.Color(255, 77, 77));
        jButton_KhoiPhucMK.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jButton_KhoiPhucMK.setForeground(java.awt.Color.white);
        jButton_KhoiPhucMK.setText("Khôi phục MK");
        jButton_KhoiPhucMK.setBorderPainted(false);
        jButton_KhoiPhucMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KhoiPhucMKActionPerformed(evt);
            }
        });

        cboGT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nu" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Số Điện Thoại");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tên NV/KH");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Tài Khoản");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Mật Khẩu");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Giới Tính");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã NV/KH");

        txtMaNV.setEnabled(false);
        txtMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNVActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Phân Quyền");

        cboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NV", "KH" }));

        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cboRole, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cboGT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel2))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel11)
                                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton_ThemNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_SuaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_KhoiPhucMK, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                .addComponent(jButton_XoaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton_QuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel_BaoLoi, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(223, 223, 223))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton_ThemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_SuaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_KhoiPhucMK, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_XoaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_QuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel10)
                                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_BaoLoi, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGap(3, 3, 3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(183, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(89, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Quản lí NV/KH ", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thống kê", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel6MousePressed

    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVActionPerformed

    private void jButton_KhoiPhucMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_KhoiPhucMKActionPerformed

    }//GEN-LAST:event_jButton_KhoiPhucMKActionPerformed

    private void jButton_SuaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SuaNhanVienActionPerformed
        try {
            suaNV();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StaffPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StaffPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_SuaNhanVienActionPerformed

    private void jButton_XoaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaNhanVienActionPerformed
        try {
            removeKH();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StaffPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StaffPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_XoaNhanVienActionPerformed

    private void jButton_ThemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemNhanVienActionPerformed
        if (flag == false) {
            autoID();
            txtTenNV.setText("");
            txtUser.setText("");
            txtMail.setText("");
            txtPass.setText("");
            txtSDT.setText("");
            flag = true;
            jButton_ThemNhanVien.setText("Lưu");
        } else {
            String maKH = txtMaNV.getText();
            String tenKH = txtTenNV.getText();
            String soDT = txtSDT.getText();
            String gioiTinh = cboGT.getSelectedItem().toString();
            String email = txtMail.getText();
            String tenDN = txtUser.getText();
            String passw = txtPass.getText();
            String role = cboRole.getSelectedItem().toString();

            User users = new User(maKH, tenKH, soDT, gioiTinh, email, tenDN, passw, role);
            try {
                InsertData.insertTaiKhoan(users, 'i');
                Controler.arrayListTaiKhoan.add(users);
                loadBangNhanVien();

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DangKi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(DangKi.class.getName()).log(Level.SEVERE, null, ex);
            }

            jButton_ThemNhanVien.setText("Thêm mới");
            flag = false;

        }

    }//GEN-LAST:event_jButton_ThemNhanVienActionPerformed

    private void txtFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindKeyReleased

    private void txtFindFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFindFocusLost
//        // TODO add your handling code here:
//        if (txtFind.getText().isEmpty()) {
//            txtFind.setText("Tìm nhân viên theo sđt");
//            txtFind.setForeground(Color.gray);
//        }
    }//GEN-LAST:event_txtFindFocusLost

    private void txtFindFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFindFocusGained
//        // TODO add your handling code here:
//        if (txtFind.getText().equals("Tìm nhân viên theo mã nhân viên/khách hàng")) {
//            txtFind.setText("");
//            txtFind.setForeground(Color.black);
//        }
    }//GEN-LAST:event_txtFindFocusGained

    private void jButton_QuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_QuayLaiActionPerformed
        // TODO add your handling code here:
        this.dispose();

        new StaffPage().setVisible(true);
    }//GEN-LAST:event_jButton_QuayLaiActionPerformed

    private void jTable_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_NhanVienMouseClicked
        // TODO add your handling code here:
        index = jTable_NhanVien.getSelectedRow();
        showDetail(index);
    }//GEN-LAST:event_jTable_NhanVienMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        KiemTraVeStaff d = new KiemTraVeStaff();
        jDesktopPane1.add(d);
        d.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BanVeMB d = new BanVeMB();
        jDesktopPane1.add(d);
        d.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindActionPerformed


    }//GEN-LAST:event_txtFindActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed

        if (txtFind.getText().length() > 0) {
            try {
                Connection con = DatabaseHelper.openConnection();
                String sql = "select * from Taikhoan where MaKh = ? ";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, txtFind.getText());
                ResultSet rs = st.executeQuery();
                int find = -1;
                while (rs.next()) {
                    if (txtFind.getText().equals(rs.getString(1))) {
                        find = 0;
                        txtMaNV.setText(rs.getString(1));
                        txtTenNV.setText(rs.getString(2));
                        txtSDT.setText(rs.getString(3));
                        txtMail.setText(rs.getString(5));
                        txtUser.setText(rs.getString(6));
                        txtPass.setText(rs.getString(7));
                        cboGT.setSelectedItem(rs.getString(4));
                        cboRole.setSelectedItem(rs.getString(8));

                    }
                }
                if (find == -1) {
                    JOptionPane.showMessageDialog(this, "Không có nhân viên trong danh sách!");
                }

                con.close();
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống!");
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed


    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int confirmed = JOptionPane.showConfirmDialog(null,
                "Bạn có chắc muốn thoát chương trình không?", "Xác nhận",
                JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
//            main m = new main();
//            m.setVisible(true);
            this.setVisible(false);
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
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
            java.util.logging.Logger.getLogger(StaffPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFind;
    private javax.swing.JComboBox<String> cboGT;
    private javax.swing.JComboBox<String> cboRole;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_KhoiPhucMK;
    private javax.swing.JButton jButton_QuayLai;
    private javax.swing.JButton jButton_SuaNhanVien;
    private javax.swing.JButton jButton_ThemNhanVien;
    private javax.swing.JButton jButton_XoaNhanVien;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_BaoLoi;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable_NhanVien;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    private void loadBangNhanVien() {
        dtmNhanVien.setRowCount(0);
        InsertData.LoadDataNhanVien();
        for (User nv : Controler.arrayListTaiKhoan) {
            dtmNhanVien.addRow(new Object[]{
                nv.getMaKH(), nv.getTenKH(), nv.getEmail(), nv.getSDT(), nv.getGioiTinh(), nv.getTenDN(), nv.getPassword(), nv.getRole()
            });
        }
    }

//    public static void LoadDataNV() {
//        try {
//            Connection conn = DatabaseHelper.openConnection();
//            Statement st = conn.createStatement();
//            String sql = "SELECT * FROM TAIKHOAN";
//            ResultSet rs = st.executeQuery(sql);
//            Controler.arrayListTaiKhoan.clear();
//            while (rs.next()) {
//                String maKH = rs.getString(1);
//                String tenKH = rs.getString(2);
//                String sdt = rs.getString(3);
//                String email = rs.getString(5);
//                String gt = rs.getString(4);
//                String tendn = rs.getString(6);
//                String pass = rs.getString(7);
//                String role = rs.getString(8);
//                User user = new User(maKH, tenKH, sdt, gt, email, tendn, pass, role);
//                Controler.arrayListTaiKhoan.add(user);
//            }
//            conn.close();
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//    }
    public User getModel() {
        User u = new User();
        u.setMaKH(txtMaNV.getText());
        u.setTenKH(txtTenNV.getText());
        u.setEmail(txtMail.getText());
        u.setSDT(txtSDT.getText());
        u.setGioiTinh(cboGT.getSelectedItem().toString());
        u.setTenDN(txtUser.getText());
        u.setPassword(txtPass.getText());
        u.setRole(cboRole.getSelectedItem().toString());
        return u;
    }

    public void showDetail(int index) {
        this.MaNV = (String) jTable_NhanVien.getValueAt(index, 0);
        System.out.println("Mã nhân viên của nhân viên đã chọn: " + this.MaNV);
        for (User nv : Controler.arrayListTaiKhoan) {
            if (nv.getMaKH().equals(this.MaNV)) {
                txtMaNV.setText(nv.getMaKH());
                txtTenNV.setText(nv.getTenKH());
                txtSDT.setText(nv.getSDT());
                txtMail.setText(nv.getEmail());
                cboGT.setSelectedItem(nv.getGioiTinh());
                txtUser.setText(nv.getTenDN());
                txtPass.setText(nv.getPassword());
                cboRole.setSelectedItem(nv.getRole());
            }
        }
    }
}
