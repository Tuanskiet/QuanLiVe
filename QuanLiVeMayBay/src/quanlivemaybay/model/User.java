/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlivemaybay.model;

/**
 *
 * @author Administrator
 */
public class User {
    String maKH, tenKH,SDT,gioiTinh, email,tenDN,password,role;

    public User() {
    }

    public User(String maKH, String tenKH, String SDT, String gioiTInh, String email, String tenDN, String password, String role) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.SDT = SDT;
        this.gioiTinh = gioiTInh;
        this.email = email;
        this.tenDN = tenDN;
        this.password = password;
        this.role = role;
    }
    

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTInh) {
        this.gioiTinh = gioiTInh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
}
