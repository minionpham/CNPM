package models;

public class KhoanPhi {
    private  String MaKhoanPhi;
    private String TenKhoanPhi;
    private int LoaiPhi; // tu nguyen la 1 bat buoc la 0
    private double SoTien;

    public KhoanPhi(String maKhoanPhi, String tenKhoanPhi, int loaiPhi, double soTien) {
        MaKhoanPhi = maKhoanPhi;
        TenKhoanPhi = tenKhoanPhi;
        LoaiPhi = loaiPhi;
        SoTien = soTien;
    }

    public String getMaKhoanPhi() {
        return MaKhoanPhi;
    }

    public void setMaKhoanPhi(String maKhoanPhi) {
        MaKhoanPhi = maKhoanPhi;
    }

    public String getTenKhoanPhi() {
        return TenKhoanPhi;
    }

    public void setTenKhoanPhi(String tenKhoanPhi) {
        TenKhoanPhi = tenKhoanPhi;
    }

    public int getLoaiPhi() {
        return LoaiPhi;
    }

    public void setLoaiPhi(int loaiPhi) {
        LoaiPhi = loaiPhi;
    }

    public int getSoTien() {
        return SoTien;
    }

    public void setSoTien(double soTien) {
        SoTien = soTien;
    }

}
