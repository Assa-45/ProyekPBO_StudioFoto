package Model.Reservasi;

import Model.Connector; // pastikan ini class koneksi kamu
import ModelMenu.StatusType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOReservasi {
    private Connection connection;

    // Constructor untuk inisialisasi connection
    public DAOReservasi() {
        connection = Connector.getConnection(); // pastikan Connector punya method ini
    }

    public boolean insert(ModelReservasi reservasi) {
        String sql = "INSERT INTO reservasi (tanggal, jam_mulai, durasi_jam, "
                + "total_harga, jam_selesai, nama_customer, nomor_hp_customer, tipe_studio, harga_per_jam, status) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, reservasi.getTanggal());
            statement.setTime(2, reservasi.getJam_mulai());
            statement.setInt(3, reservasi.getDurasi_jam());            
            statement.setDouble(4, reservasi.getTotal_harga());
            statement.setTime(5, reservasi.getJam_selesai());
            statement.setString(6, reservasi.getNama_customer());
            statement.setString(7, reservasi.getNomor_hp_customer());
            statement.setString(8, reservasi.getTipe_studio());
            statement.setDouble(9, reservasi.getHarga_per_jam());
            statement.setString(10, reservasi.getStatus().name());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Insert Failed: " + e.getMessage());
            return false;
        }
    }

    public boolean update(ModelReservasi reservasi) {
        String sql = "UPDATE reservasi SET tanggal=?, jam_mulai=?, durasi_jam=?, "
                + "total_harga=?, jam_selesai=?, nama_customer=?, nomor_hp_customer=?, tipe_studio=?, harga_per_jam=? "
                + "WHERE id_reservasi=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, reservasi.getTanggal());
            statement.setTime(2, reservasi.getJam_mulai());
            statement.setInt(3, reservasi.getDurasi_jam());
            statement.setDouble(4, reservasi.getTotal_harga());
            statement.setTime(5, reservasi.getJam_selesai());
            statement.setString(6, reservasi.getNama_customer());
            statement.setString(7, reservasi.getNomor_hp_customer());
            statement.setString(8, reservasi.getTipe_studio());
            statement.setDouble(9, reservasi.getHarga_per_jam());
            statement.setInt(10, reservasi.getId_Reservasi()); // ID sebagai kondisi update

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Update Failed: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idReservasi) {
        String sql = "DELETE FROM reservasi WHERE id_reservasi=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idReservasi);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getMessage());
            return false;
        }
    }

    public List<ModelReservasi> getAll() {
        List<ModelReservasi> list = new ArrayList<>();
        String sql = "SELECT * FROM reservasi";

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                ModelReservasi reservasi = new ModelReservasi();
                reservasi.setId_Reservasi(rs.getInt("id_reservasi"));
                reservasi.setTanggal(rs.getDate("tanggal"));
                reservasi.setJam_mulai(rs.getTime("jam_mulai"));
                reservasi.setDurasi_jam(rs.getInt("durasi_jam"));
                reservasi.setNama_customer(rs.getString("nama_customer"));
                reservasi.setNomor_hp_customer(rs.getString("nomor_hp_customer"));
                reservasi.setTipe_studio(rs.getString("tipe_studio"));
                reservasi.setHarga_per_jam(rs.getDouble("harga_per_jam"));
                reservasi.setJam_selesai(rs.getTime("jam_selesai")); 
                reservasi.setTotal_harga(rs.getDouble("total_harga"));
                
                String statusFromDB = rs.getString("status");
                reservasi.setStatus(StatusType.valueOf(statusFromDB));

                list.add(reservasi);
            }
        } catch (SQLException e) {
            System.out.println("GetAll Failed: " + e.getMessage());
        }
        return list;
    }
}

