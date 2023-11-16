package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class NhanKhauModel {
    private String MaHoKhau;
    private  String QhvoiChuHo;
    private String Cmnd;
    private  String HoTen;
    private Time NgaySinh;
    private String NoiSinh;
    private String NguyenQuan;
    private String DanToc;
    private String NgheNghiep;
    private String NoiLamViec;
    private Time NgaycapCMND;
    private String NoicapCMND;

    public NhanKhauModel(String maHoKhau, String qhvoiChuHo, String cmnd, String hoTen, Time ngaySinh, String noiSinh, String nguyenQuan, String danToc, String ngheNghiep, String noiLamViec, Time ngaycapCMND, String noicapCMND) {
        MaHoKhau = maHoKhau;
        QhvoiChuHo = qhvoiChuHo;
        Cmnd = cmnd;
        HoTen = hoTen;
        NgaySinh = ngaySinh;
        NoiSinh = noiSinh;
        NguyenQuan = nguyenQuan;
        DanToc = danToc;
        NgheNghiep = ngheNghiep;
        NoiLamViec = noiLamViec;
        NgaycapCMND = ngaycapCMND;
        NoicapCMND = noicapCMND;
    }

    public String getMaHoKhau() {
        return MaHoKhau;
    }

    public void setMaHoKhau(String maHoKhau) {
        MaHoKhau = maHoKhau;
    }

    public String getQhvoiChuHo() {
        return QhvoiChuHo;
    }

    public void setQhvoiChuHo(String qhvoiChuHo) {
        QhvoiChuHo = qhvoiChuHo;
    }

    public String getCmnd() {
        return Cmnd;
    }

    public void setCmnd(String cmnd) {
        Cmnd = cmnd;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public Time getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Time ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getNoiSinh() {
        return NoiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        NoiSinh = noiSinh;
    }

    public String getNguyenQuan() {
        return NguyenQuan;
    }

    public void setNguyenQuan(String nguyenQuan) {
        NguyenQuan = nguyenQuan;
    }

    public String getDanToc() {
        return DanToc;
    }

    public void setDanToc(String danToc) {
        DanToc = danToc;
    }

    public String getNgheNghiep() {
        return NgheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        NgheNghiep = ngheNghiep;
    }

    public String getNoiLamViec() {
        return NoiLamViec;
    }

    public void setNoiLamViec(String noiLamViec) {
        NoiLamViec = noiLamViec;
    }

    public Time getNgaycapCMND() {
        return NgaycapCMND;
    }

    public void setNgaycapCMND(Time ngaycapCMND) {
        NgaycapCMND = ngaycapCMND;
    }

    public String getNoicapCMND() {
        return NoicapCMND;
    }

    public void setNoicapCMND(String noicapCMND) {
        NoicapCMND = noicapCMND;
    }
    //THEM NHAN KHAU
public  boolean addNhanKhau(NhanKhauModel nhanKhauModel) throws ClassNotFoundException, SQLException{
    Connection connection;
    String sql="INSERT INTO NhanKhau(MaHoKhau,QhvoiChuHo,CMND,HoTen,NgaySinh,NoiSinh,NguyenQuan,DanToc,NgheNghiep,NoiLamViec,NgaycapCMND,NoicapCMND )" +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement preparedStatement= connection.prepareStatement(sql);
    preparedStatement.setString(1,nhanKhauModel.getMaHoKhau());
    preparedStatement.setString(2,nhanKhauModel.getQhvoiChuHo());
    preparedStatement.setString(3,nhanKhauModel.getCmnd());
    preparedStatement.setString(4,nhanKhauModel.getHoTen());
    preparedStatement.setTime(5,nhanKhauModel.getNgaySinh());
    preparedStatement.setString(6,nhanKhauModel.getNoiSinh());
    preparedStatement.setString(7,nhanKhauModel.getNguyenQuan());
    preparedStatement.setString(8,nhanKhauModel.getDanToc());
    preparedStatement.setString(9,nhanKhauModel.getNgheNghiep());
    preparedStatement.setString(10,nhanKhauModel.getNoiLamViec());
    preparedStatement.setTime(11,nhanKhauModel.getNgaycapCMND());
    preparedStatement.setString(12,nhanKhauModel.getNoicapCMND());
    preparedStatement.executeUpdate();

    preparedStatement.close();
    connection.close();
    return true;}

    // UPDATE NHAN KHAU
    public boolean updateNhanKhau(String MaHoKhau,String Hoten,String NgheNghiep,String NoiLamViec) throws  SQLException,ClassNotFoundException {
              Connection connection;
              // Table: NhanKhau
              String sql= "UPDATE FROM NhanKhau"+
                      "SET HoTen="+Hoten+
                      ",NgheNghiep ="+NgheNghiep+
                      ",NoiLamViec ="+NoiLamViec+
                      "WHERE MaHoKhau =" + MaHoKhau;
              PreparedStatement preparedStatement= connection.prepareStatement(sql);
              preparedStatement.executeUpdate();
              preparedStatement.close();
              connection.close();
              return true;
    }
// Xoa nhan khau
//CMND la khoa chinh
public boolean delNhanKhau(String CMND,String MaHoKhau) throws ClassNotFoundException,SQLException{
        Connection connection;
        String sql= "DELETE FROM NhanKhau"+
                "WHERE CMND="+CMND;
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.executeUpdate();

        sql="UPDATE FROM HoKhau SET HoKhau.Sothanhvien= HoKhau.Sothanhvien-1"+
        "WHERE MaHoKhau="+MaHoKhau;
    PreparedStatement preparedStatement=connection.prepareStatement(sql);
    preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return tru--
}

// XEM DANH SACH NHAN KHAU
    public List<NhanKhauModel> getlistNhanKhau() throws ClassNotFoundException,SQLException{
        List<NhanKhauModel> list=new ArrayList<>();
        Connection connection;
        String query=" SELECT*FROM NhanKhau";
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        ResultSet resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
            String MaHoKhau= resultSet.getNString(1);
            String QhvoiChuho= resultSet.getNString(2);
            String Cmnd= resultSet.getNString(3);
            String HoTen= resultSet.getNString(4);
            Time NgaySinh=resultSet.getTime(5);
            String NoiSinh= resultSet.getNString(6);
            String NguyenQuan= resultSet.getNString(7);
            String DanToc= resultSet.getNString(8);
            String NgheNghiep= resultSet.getNString(9);
            String NoiLamViec= resultSet.getNString(10);
            Time NgaycapCMND=resultSet.getTime(11);
            String NoicapCMND=resultSet.getString(12);
            NhanKhauModel nhanKhauModel=new NhanKhauModel(MaHoKhau,QhvoiChuho,Cmnd,HoTen,NgaySinh,NoiSinh,NguyenQuan,DanToc,NgheNghiep,NoiLamViec,NgaycapCMND,NoicapCMND);
            list.add(nhanKhauModel);
        }
        preparedStatement.close();
        connection.close();
        return list;
    }

// Tim kiem nhan khau
    public boolean findNhanKhau(String CMND) throws  ClassNotFoundException,SQLException{
        Connection connection;
        String sql="SELECT*FROM NhanKhau"+
                "WHERE CMND="+CMND;
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        if(resultSet.first()) return true;
        return false;
    }

}


