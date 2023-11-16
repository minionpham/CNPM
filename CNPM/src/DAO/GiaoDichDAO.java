package DAO;

import models.GiaoDich;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GiaoDichDAO {
    // Them giao dich
    public boolean addGiaoDich(GiaoDich giaoDich) throws ClassNotFoundException, SQLException{
        Connection connection;
        String sql="INSERT INTO GiaoDich(IdGiaoDich,MaKhoanPhi,SoTien,Cmnd,MaHoKhau,ThoiGian)"
                + "VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1, giaoDich.getIdGiaoDich());
        preparedStatement.setString(2, giaoDich.getMaKhoanPhi());
        preparedStatement.setDouble(3, giaoDich.getSoTien());
        preparedStatement.setString(4, giaoDich.getCmnd());
        preparedStatement.setString(5, giaoDich.getMaHoKhau());
        preparedStatement.setTime(6, giaoDich.getThoiGian());

        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;

    }
    // xoa giao dich
    public boolean delGiaoDich(GiaoDich giaoDich) throws ClassNotFoundException,SQLException{
        Connection connection;
        String sql="DELETE FORM GiaoDich"+
                "WHERE IdGiaoDich="+giaoDich.getIdGiaoDich();
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;
    }

    // xem giao dich
    public List<GiaoDich> getlistGiaoDich() throws  ClassNotFoundException,SQLException{
        Connection connection;
        List<GiaoDich> list=new ArrayList<>();
        String sql="SELECT* FROM GiaoDich";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        ResultSet resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
            String idgiaodich= resultSet.getString(1);
            String makhoanphi= resultSet.getString(2);
            Double sotien= resultSet.getDouble(3);
            String cmnd= resultSet.getString(4);
            String mahokhau= resultSet.getString(5);
            Time thoigian= resultSet.getTime(6);
            GiaoDich giaoDich=new GiaoDich(idgiaodich,makhoanphi,sotien,cmnd,mahokhau,thoigian);
            list.add(giaoDich);
        }
        preparedStatement.close();
        connection.close();
        return list;

    }

}
