package DAO;

import models.KhoanPhi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhoanPhiDAO {
     // Tao Khoan Phi
    // table KhoanPhi

    public boolean addKhoanPhi(KhoanPhi khoanPhi) throws ClassNotFoundException, SQLException{
        Connection connection;
        String sql= " INSERT INTO KhoanPhi(MaKhoanPhi,TenKhoanPhi,LoaiPhi,SoTien)"+
                "VALUES (?,?,?,?)";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1, khoanPhi.getMaKhoanPhi());
        preparedStatement.setString(2, khoanPhi.getTenKhoanPhi());
        preparedStatement.setString(3,khoanPhi.getLoaiPhi());
        preparedStatement.setDouble(4,khoanPhi.getSoTien());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;
    }

    // xem khoan phi
    public List<KhoanPhi> getlistKhoanPhi() throws ClassNotFoundException,SQLException{
        List<KhoanPhi> list=new ArrayList<>();
        Connection connection;
        String query="SELECT* FROM KhoanPhi";
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        ResultSet resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
            String makhoanphi= resultSet.getNString("MaKhoanPhi");
            String tenkhoanphi= resultSet.getNString("TenKhoanPhi");
            int loaiphi=resultSet.getInt("LoaiPhi");
            int sotien=resultSet.getDouble("SoTien");

            KhoanPhi khoanPhi=new KhoanPhi(makhoanphi,tenkhoanphi,loaiphi,sotien);
            list.add(khoanPhi);

        }
        preparedStatement.close();
        connection.close();
        return list;
    }

    //Xoa khoan phi
    // xoa trong table KhoanPhi va table GiaoDich lien quan den ma khoan phi
    public boolean delKhoanPhi(KhoanPhi khoanPhi) throws ClassNotFoundException,SQLException {
        Connection connection;
        String sql;
        sql = "DELETE FROM KhoanPhi"
                + "WHERE MaKhoanPhi=" + khoanPhi.getMaKhoanPhi();
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        sql="DELETE FROM GiaoDich"+
                "WHERE MaKhoanPhi="+ khoanPhi.getMaKhoanPhi();
        preparedStatement= connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;

    }


}

