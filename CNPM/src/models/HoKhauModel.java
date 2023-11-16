package models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class HoKhauModel {
    private String MaHoKhau;
    private String TenChuHo;
    private String CmndChuHo;
    private int Sothanhvien;
    private String DiaChi;
    private String GhiChu;
    
    public HoKhauModel(){}

    public HoKhauModel(String maHoKhau, String tenChuHo, String cmndChuHo, int sothanhvien, String diaChi, String ghiChu) {
        MaHoKhau = maHoKhau;
        TenChuHo = tenChuHo;
        CmndChuHo = cmndChuHo;
        Sothanhvien = sothanhvien;
        DiaChi = diaChi;
        GhiChu = ghiChu;
    }

    public String getMaHoKhau() {
        return MaHoKhau;
    }

    public void setMaHoKhau(String maHoKhau) {
        MaHoKhau = maHoKhau;
    }

    public String getTenChuHo() {
        return TenChuHo;
    }

    public void setTenChuHo(String tenChuHo) {
        TenChuHo = tenChuHo;
    }

    public String getCmndChuHo() {
        return CmndChuHo;
    }

    public void setCmndChuHo(String cmndChuHo) {
        CmndChuHo = cmndChuHo;
    }

    public int getSothanhvien() {
        return Sothanhvien;
    }

    public void setSothanhvien(int sothanhvien) {
        Sothanhvien = sothanhvien;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }


//Them, sua, xoa, Xem ho khau
    // Them ho khau

public boolean addHoKhau  throws ClassNotFoundException, SQLException(HoKhauModel HoKhau){
         Connection connection;
         String sql = "INSERT INTO HoKhau (MaHoKhau,TenChuHo,CmndChuHo,Sothanhvien,DiaChi,GhiChu)"+
                 "VALUES (?,?,?,?,?,?)";
         PreparedStatement preparedStatement=connection.prepareStatement(sql);
         preparedStatement.setString(1,HoKhau.getMaHoKhau());
         preparedStatement.setString(2,HoKhau.getTenChuHo());
         preparedStatement.setString(3,HoKhau.getCmndChuHo());
         preparedStatement.setInt(4,HoKhau.getSothanhvien());
         preparedStatement.setString(5,HoKhau.getDiaChi());
         preparedStatement.setString(6,HoKhau.getGhiChu());
         preparedStatement.executeUpdate();

         preparedStatement.close();
         connection.close();
         return true;

}

// xoa ho khau theo ma ho khau  // xoa tu table HoKhau

public  boolean delHoKhau  throws ClassNotFoundException, SQLException (String MaHoKhau){
        Connection connection;
        String sql= "DELETE FROM HoKhau"+"WHERE MaHoKhau = "+ MaHoKhau;
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        connection.close();
        return  true;

}
// sua theo ma ho khau va co the sua dia chi or so thanh vien trong ho khau
public boolean updateHoKhau  throws ClassNotFoundException,SQLException (String MaHoKhau,String DiaChi,int Sothanhvien){
        Connection connection;
        String sql= "UPDATE FROM HoKhau" + "SET"+
                "DiaChi=" + DiaChi
                +",SoThanhVien=" + Sothanhvien
                +"WHERE MaHoKhau =" + MaHoKhau ;
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        connection.close();
        return true;
}

// Xem ho khau
// table: HoKhau
public List<HoKhauModel> getListHoKhau() throws ClassNotFoundException,SQLException{
        List<HoKhauModel> list=new ArrayList<>();
        Connection connection;
        String sql= "SELECT* FROM HoKhau";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            String MaHoKhau=resultSet.getNString("MaHoKhau"); // ten truong trong SQL
            String TenChuHo = resultSet.getNString("TenChuHo");
            String CmndChuHo= resultSet.getNString("CmndChuHo");
            int Sothanhvien= resultSet.getInt("Sothanhvien");
            String DiaChi = resultSet.getNString("DiaChi");
            String GhiChu= resultSet.getNString("GhiChu");
            HoKhauModel hoKhauModel1=new HoKhauModel(MaHoKhau,TenChuHo,CmndChuHo,DiaChi,GhiChu);
            list.add(hoKhauModel1);
        }
        preparedStatement.close();
        connection.close();
        return list;
}

//Tim kiem ho khau
    public boolean findHoKhau(String TenChuHo, String MaHoKhau) throws ClassNotFoundException,SQLException{
        List<HoKhauModel> list= new ArrayList<>();
        Connection connection;
        String sql= "SELECT* FROM HoKhau"+
                "WHERE TenChuHo="+ TenChuHo+
                "OR MaHoKhau="+ MaHoKhau ;
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            String MaHoKhau=resultSet.getNString("MaHoKhau"); // ten truong trong SQL
            String TenChuHo = resultSet.getNString("TenChuHo");
            String CmndChuHo= resultSet.getNString("CmndChuHo");
            int Sothanhvien= resultSet.getInt("Sothanhvien");
            String DiaChi = resultSet.getNString("DiaChi");
            String GhiChu= resultSet.getNString("GhiChu");
            HoKhauModel hoKhauModel1=new HoKhauModel(MaHoKhau,TenChuHo,CmndChuHo,DiaChi,GhiChu);
            list.add(hoKhauModel1);
        }
        if(list.isEmpty()){
            return false;
        }
        return true;
    }

// Tach ho khau chi la viec xoa nhan khau trong ho khau r tao ho khau moi




}
