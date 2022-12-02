/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlivemaybay.helper;

import quanlivemaybay.model.User;
import java.sql.*;
import javax.swing.JOptionPane;

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
}
