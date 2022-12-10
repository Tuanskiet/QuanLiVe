/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlivemaybay.model;

/**
 *
 * @author ADMIN
 */
public class Datvemain {
    private String maVe,maKH,ngayDat;

    public Datvemain() {
    }

    public Datvemain(String maVe, String maKH, String ngayDat) {
        this.maVe = maVe;
        this.maKH = maKH;
        this.ngayDat = ngayDat;
    }
    

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    
    
}
