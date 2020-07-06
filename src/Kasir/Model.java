package Kasir;

import javax.swing.*;
import java.sql.*;

class Model {
    Connection connection;
    ResultSet resultSet;
    Statement statement;

    int transaksi = 0;

    Object[] searchBarang = new Object[6];

    Model(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/kasir","root","");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Database tidak ada","Error Database",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Driver SQL tidak diketahui","Error SQL",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public int getTransaksi() {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM transaksi");

            while (resultSet.next()){
                transaksi++;
            }
            statement.close();
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null,throwables.getMessage(),"Error SQL",JOptionPane.ERROR_MESSAGE);
        }
        return transaksi;
    }

    public Object[] getSearchBarang(long id) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM barang JOIN satuan ON barang.satuan = satuan.id_satuan WHERE barang.id_barang = "+id+"");

            while (resultSet.next()){
                searchBarang[0] = resultSet.getLong("id_barang");
                searchBarang[1] = resultSet.getString("nama_barang");
                searchBarang[2] = resultSet.getString("satuan.nama_satuan");
                searchBarang[3] = resultSet.getInt("harga");
                searchBarang[4] = resultSet.getInt("diskon");
            }
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error SQL",JOptionPane.ERROR_MESSAGE);
        }
        return searchBarang;
    }
}
