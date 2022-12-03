/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlivemaybay.helper;

import quanlivemaybay.model.User;
import java.sql.*;
import javax.swing.JOptionPane;
import quanlivemaybay.model.Controler;

/**
 *
 * @author Administrator
 */
public class InsertData {

    public static void insertTaiKhoan(User user, Character i) throws Exception {
        String sqlCommand = "INSERT INTO TAIKHOAN VALUES (?,?,?,?,?,?,?,?)";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement ps = con.prepareStatement(sqlCommand);
            ps.setString(1, user.getMaKH());
            ps.setString(2, user.getTenKH());
            ps.setString(3, user.getSDT());
            ps.setString(4, user.getGioiTinh());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getTenDN());
            ps.setString(7, user.getPassword());
            ps.setString(8, "KH");
            ps.execute();

            JOptionPane.showMessageDialog(null, "Đăng kí thành công!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void LoadDataToArray() {
        try {
            Connection conn = DatabaseHelper.openConnection();
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM TAIKHOAN";
            ResultSet rs = st.executeQuery(sql);
            Controler.arrayListTaiKhoan.clear();
            while (rs.next()) {
                String maKH = rs.getString(1);
                String tenKH = rs.getString(2);
                String sdt = rs.getString(3);
                String email = rs.getString(5);
                String gt = rs.getString(4);
                String tendn = rs.getString(6);
                String pass = rs.getString(7);
                String role = rs.getString(8);
                User user = new User(maKH, tenKH, sdt, gt, email, tendn, pass, role);
                Controler.arrayListTaiKhoan.add(user);
            }
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
