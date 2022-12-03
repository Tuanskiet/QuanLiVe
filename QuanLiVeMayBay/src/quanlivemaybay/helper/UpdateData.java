/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlivemaybay.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import quanlivemaybay.model.User;

/**
 *
 * @author Administrator
 */
public class UpdateData {
    public static boolean updateTaiKhoan(User user) throws Exception {
        String sqlCommand = "UPDATE TAIKHOAN SET maKh = ?, tenkh = ?,sdt = ?, gioitinh = ?, email = ?,"
                + "tendangnhap = ?, matkhau =?, role = ? WHERE MAKH = '" + user.getMaKH() + "'";
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

            JOptionPane.showMessageDialog(null, "Sửa thông tin thành công!");

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }
}
