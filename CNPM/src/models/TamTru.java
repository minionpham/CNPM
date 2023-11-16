package models;

import java.sql.Connection;
import java.sql.Time;

public class TamTru {
    private String MaTamTru;
    private String HoTen;
    private String CMND;
    private String MaHoKhau;
    private String QuanHevsChuHo;
    private Time NgayDK;
    private Time ThoiGian;
    private String DiaChiTrc;

    public String getMaTamTru() {
        return MaTamTru;
    }

    public void setMaTamTru(String maTamTru) {
        MaTamTru = maTamTru;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getMaHoKhau() {
        return MaHoKhau;
    }

    public void setMaHoKhau(String maHoKhau) {
        MaHoKhau = maHoKhau;
    }

    public String getQuanHevsChuHo() {
        return QuanHevsChuHo;
    }

    public void setQuanHevsChuHo(String quanHevsChuHo) {
        QuanHevsChuHo = quanHevsChuHo;
    }

    public Time getNgayDK() {
        return NgayDK;
    }

    public void setNgayDK(Time ngayDK) {
        NgayDK = ngayDK;
    }

    public Time getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Time thoiGian) {
        ThoiGian = thoiGian;
    }

    public String getDiaChiTrc() {
        return DiaChiTrc;
    }

    public void setDiaChiTrc(String diaChiTrc) {
        DiaChiTrc = diaChiTrc;
    }

    public boolean dangkitamtru(TamTru tamtru){
        Connection connection;

    }



}
