/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlivemaybay.helper;

import quanlivemaybay.model.User;
import java.sql.*;
import javax.swing.JOptionPane;
import quanlivemaybay.model.Controler;
import quanlivemaybay.VeMayBay;
import quanlivemaybay.model.Datvemain;

/**
 *
 * @author Administrator
 */
public class InsertData {

    public static void insertTaiKhoan(User user, Character i) throws Exception {
        String sqlCommand = "INSERT INTO TAIKHOAN VALUES (?,?,?,?,?,?,?,?,?)";
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
            ps.setString(8, user.getRole());
            ps.setBoolean(9, false);

            ps.execute();

            JOptionPane.showMessageDialog(null, "Đăng kí thành công!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void LoadDataToArray(String ma) {
        try {
            Connection conn = DatabaseHelper.openConnection();
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM TAIKHOAN WHERE TENDANGNHAP = '" + ma + "'";
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

    public static void LoadDataNhanVien() {
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

    public static void LoadDataVe() {
        try {
            Connection conn = DatabaseHelper.openConnection();
            String sql = "SELECT * FROM Ve ";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Controler.arrayListVe.clear();
            while (rs.next()) {
                String MaVe = rs.getString(1);
                String Diemdi = rs.getString(2);
                String Diemden = rs.getString(3);
                String LoaiVe = rs.getString(4);
                String GioBay = rs.getString(5);
                String NgayBay = String.valueOf(rs.getDate(6));
                String NgayBan = String.valueOf(rs.getDate(7));
                String giaVe = rs.getString(8);
                VeMayBay ve = new VeMayBay(MaVe, Diemdi, Diemden, LoaiVe, GioBay, NgayBay, NgayBan, Float.parseFloat(giaVe));
                Controler.arrayListVe.add(ve);
            }
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void insertVe(VeMayBay ve) {
        String sqlCommand = "INSERT INTO Ve VALUES (?,?,?,?,?,?,?,?)";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement ps = con.prepareStatement(sqlCommand);
            ps.setString(1, ve.getMaVe());
            ps.setString(2, ve.getDiemdi());
            ps.setString(3, ve.getDiemden());
            ps.setString(4, ve.getLoaiVe());
            ps.setString(5, ve.getGioBay());
            ps.setString(6, String.valueOf(ve.getNgayBay()));
            ps.setString(7, String.valueOf(ve.getNgayBan()));
            ps.setString(8, String.valueOf(ve.getGiaVe()));

            ps.execute();

            JOptionPane.showMessageDialog(null, "Tạo vé thành công!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void LoadDataDatVe(String makh) {
        try {
            Connection conn = DatabaseHelper.openConnection();
            String sql = "SELECT * FROM datve where MaKh = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, makh);
            ResultSet rs = ps.executeQuery();
            Controler.arrayListDatVe.clear();
            while (rs.next()) {
                String MaVe = rs.getString(1);
                String MaKh = rs.getString(2);
                String NgayDat = String.valueOf(rs.getDate(3));
                String GioDat = rs.getString(4);
                Datvemain ve = new Datvemain(MaVe, MaKh, NgayDat, GioDat);
                Controler.arrayListDatVe.add(ve);
            }
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void insertDatVe(String mave, String makh, Date ngaydat, String giodat) throws Exception {
        String sqlCommand = "INSERT INTO datve VALUES (?,?,?,?)";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement ps = con.prepareStatement(sqlCommand);
            ps.setString(1, mave);
            ps.setString(2, makh);
            ps.setDate(3, ngaydat);
            ps.setString(4, giodat);
            ps.execute();

            JOptionPane.showMessageDialog(null, "Mua thành công!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
