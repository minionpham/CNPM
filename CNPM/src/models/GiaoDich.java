package models;

import java.sql.Time;

public class GiaoDich {
    private String IdGiaoDich;
    private String MaKhoanPhi;
    private int SoTien;
    private String Cmnd;
    private String MaHoKhau;
    private Time ThoiGian;

    public GiaoDich(String idGiaoDich, String maKhoanPhi, int soTien, String cmnd, String maHoKhau, Time thoiGian) {
        IdGiaoDich = idGiaoDich;
        MaKhoanPhi = maKhoanPhi;
        SoTien = soTien;
        Cmnd = cmnd;
        MaHoKhau = maHoKhau;
        ThoiGian = thoiGian;
    }

    public String getIdGiaoDich() {
        return IdGiaoDich;
    }

    public void setIdGiaoDich(String idGiaoDich) {
        IdGiaoDich = idGiaoDich;
    }

    public String getMaKhoanPhi() {
        return MaKhoanPhi;
    }

    public void setMaKhoanPhi(String maKhoanPhi) {
        MaKhoanPhi = maKhoanPhi;
    }

    public int getSoTien() {
        return SoTien;
    }

    public void setSoTien(int soTien) {
        SoTien = soTien;
    }

    public String getCmnd() {
        return Cmnd;
    }

    public void setCmnd(String cmnd) {
        Cmnd = cmnd;
    }

    public String getMaHoKhau() {
        return MaHoKhau;
    }

    public void setMaHoKhau(String maHoKhau) {
        MaHoKhau = maHoKhau;
    }

    public Time getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Time thoiGian) {
        ThoiGian = thoiGian;
    }

}
