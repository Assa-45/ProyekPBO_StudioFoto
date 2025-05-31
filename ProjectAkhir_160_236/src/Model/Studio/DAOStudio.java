package Model.Studio;
import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOStudio {
    public void insert (ModelStudio studio) {
    try{
        String query = "INSERT INTO studio (nama_studi, tipe, harga_per_jam) VALUES (?, ?)";
        
        PreparedStatement statement;
        statement = Connector.Connect().prepareStatement(query);
        statement.setString(1, studio.getNama_studio());
        statement.setString(2, studio.getTipe());
        statement.setDouble(3, studio.getHarga_per_jam());
        
        statement.executeUpdate();
        statement.close();
    } catch (SQLException e){
        System.out.println("Input Failed " + e.getLocalizedMessage());
    }
    }
    public String getTipeById(int idStudio) {
        String tipe = "";
        try {
            String query = "SELECT tipe FROM studio WHERE id_studio = ?";
            PreparedStatement stmt = Connector.Connect().prepareStatement(query);
            stmt.setInt(1, idStudio);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tipe = rs.getString("tipe");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Gagal mengambil tipe studio: " + e.getLocalizedMessage());
        }
        return tipe;
    }
}
