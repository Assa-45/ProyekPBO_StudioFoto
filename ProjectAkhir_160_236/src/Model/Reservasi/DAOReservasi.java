package Model.Reservasi;
import Model.Connector;
import java.sql.*;
import Model.Studio.DAOStudio;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class DAOReservasi {
        public void insert (ModelReservasi customer) {
    try{
        // 1. Ambil tipe studio berdasarkan id_studio
            DAOStudio daoStudio = new DAOStudio();
            String tipeStudio = daoStudio.getTipeById(customer.getId_studio());

            // 2. Hitung total harga berdasarkan tipe studio dan durasi jam
            customer.hitungTotal_harga(tipeStudio);
            
       String query = "INSERT INTO reservasi (tanggal, jam_mulai, durasi_jam, total_harga, "
               + "id_studio, id_operator, id_customer, jam_selesai) VALUES "
               + "(?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = Connector.Connect().prepareStatement(query);
        statement.setDate(1, customer.getTanggal());
        statement.setTime(2, customer.getJam_mulai());
        statement.setInt(3, customer.getDurasi_jam());
        statement.setDouble(4, customer.getTotal_harga());
        statement.setInt(5, customer.getId_studio());
        statement.setInt(6, customer.getId_operator());
        statement.setInt(7, customer.getId_customer());
        statement.setTime(8, customer.getJam_selesai()); 
        
        statement.executeUpdate();
        statement.close();
    } catch (SQLException e){
        System.out.println("Input Failed " + e.getLocalizedMessage());
    }
    }
}
