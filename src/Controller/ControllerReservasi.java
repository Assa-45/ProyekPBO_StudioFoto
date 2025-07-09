package Controller;

import Model.Reservasi.DAOReservasi;
import Model.Reservasi.ModelReservasi;
import Model.TemplateTable;
import ModelMenu.StatusType;
import View.ViewReservasi;
import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ControllerReservasi {

    private ViewReservasi viewreservasi;
    private DAOReservasi daoreservasi;
    private List<ModelReservasi> data;
    
    private LocalDate tanggal;
    private LocalTime jam_selesai;
    private StatusType status;

    public ControllerReservasi(ViewReservasi viewreservasi) {
        this.viewreservasi = viewreservasi;
        this.daoreservasi = new DAOReservasi();
        this.data = new ArrayList<>();
    }


    public void insertData(
        Date tanggal, Time jamMulai, int durasiJam,
        String namaCustomer, String noHpCustomer,
        String tipeStudio, double hargaPerJam) {

        ModelReservasi statement = new ModelReservasi();
        statement.setTanggal(tanggal);
        statement.setJam_mulai(jamMulai);
        statement.setDurasi_jam(durasiJam);
        statement.setNama_customer(namaCustomer);
        statement.setNomor_hp_customer(noHpCustomer);
        statement.setTipe_studio(tipeStudio);
        statement.setHarga_per_jam(hargaPerJam);
        statement.setStatus(StatusType.ONGOING);
        
        statement.hitungJamSelesai();
        statement.hitungTotalHarga();

        boolean inputBerhasil = daoreservasi.insert(statement);
        if(inputBerhasil){
            JOptionPane.showMessageDialog(null, createStyledPanel("Berhasil menambahkan reservasi baru!"), "Sukses", JOptionPane.INFORMATION_MESSAGE);
            new ViewReservasi();
            viewreservasi.dispose();
        } else {
            JOptionPane.showMessageDialog(null, createStyledPanel("Terjadi Kesalahan saat menginput data"), "Input Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showAll() {
        data = daoreservasi.getAll();

        for (ModelReservasi r : data) {
            java.sql.Date tgl = r.getTanggal();
            Time jamSelesai = r.getJam_selesai();

            if (tgl != null && jamSelesai != null) {
                LocalDate localDate = tgl.toLocalDate();         
                LocalTime localTime = jamSelesai.toLocalTime();     

                LocalDateTime endTime = LocalDateTime.of(localDate, localTime);
                LocalDateTime now = LocalDateTime.now();

                if (now.isAfter(endTime)) {
                    r.setStatus(StatusType.DONE);
                } else {
                    r.setStatus(StatusType.ONGOING);
                }
            }
        }

        
        TemplateTable<ModelReservasi> tabelReservasi = new TemplateTable<>(
            data,
            new String[]{"ID", "Tanggal", "Nama Customer", "No HP", "Jenis Studio",  "Harga Per Jam", "Jam Mulai", "Jam Selesai", "Durasi (jam)", "Total Harga", "Status"},
            (data, columnIndex) -> {
                switch (columnIndex) {
                    case 0: return data.getId_Reservasi();
                    case 1: return data.getTanggal();
                    case 2: return data.getNama_customer();
                    case 3: return data.getNomor_hp_customer();
                    case 4: return data.getTipe_studio();
                    case 5: return data.getHarga_per_jam();
                    case 6: return data.getJam_mulai() != null ? data.getJam_mulai().toString() : "N/A";
                    case 7: return data.getJam_selesai() != null ? data.getJam_selesai().toString() : "N/A";
                    case 8: return data.getDurasi_jam();
                    case 9: return data.getTotal_harga();
                    case 10: return data.getStatus();
                    default: return null;
                }
            }
        );

        if (viewreservasi != null && viewreservasi.getTableReservasi() != null) {
            JTable table = viewreservasi.getTableReservasi();
            table.setModel(tabelReservasi);
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(0).setWidth(0);
        } else {
            System.err.println("Tidak ada view untuk menampilkan data.");
        }
    }
    
    public void search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            // Kalau kosong, reset ke show all
            showAll();
            return;
        }

        List<ModelReservasi> filteredData = new ArrayList<>();
        for (ModelReservasi r : daoreservasi.getAll()) {  // atau simpan data all di variabel biar gak getAll() berulang
            if (r.getNama_customer().toLowerCase().contains(keyword.toLowerCase()) 
                || r.getNomor_hp_customer().contains(keyword)) {
                filteredData.add(r);
            }
        }

        TemplateTable<ModelReservasi> tabelReservasi = new TemplateTable<>(
            filteredData,
            new String[]{"ID", "Tanggal", "Nama Customer", "No HP", "Jenis Studio",  "Harga Per Jam", "Jam Mulai", "Jam Selesai", "Durasi (jam)", "Total Harga"},
            (data, columnIndex) -> {
                switch (columnIndex) {
                    case 0: return data.getId_Reservasi();
                    case 1: return data.getTanggal();
                    case 2: return data.getNama_customer();
                    case 3: return data.getNomor_hp_customer();
                    case 4: return data.getTipe_studio();
                    case 5: return data.getHarga_per_jam();
                    case 6: return data.getJam_mulai() != null ? data.getJam_mulai().toString() : "N/A";
                    case 7: return data.getJam_selesai() != null ? data.getJam_selesai().toString() : "N/A";
                    case 8: return data.getDurasi_jam();
                    case 9: return data.getTotal_harga();
                    case 10: return data.getStatus();
                    default: return null;
                }
            }
        );

        if (viewreservasi != null && viewreservasi.getTableReservasi() != null) {
            JTable table = viewreservasi.getTableReservasi();
            table.setModel(tabelReservasi);
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(0).setWidth(0);
        } else {
            System.err.println("Tidak ada view untuk menampilkan data.");
        }
    }

    
    public void editReservasi(int id, 
            Date tanggal, Time jamMulai, int durasiJam,
            String namaCustomer, String noHpCustomer,
            String tipeStudio, double hargaPerJam){
        try{
            if (namaCustomer == null || namaCustomer.trim().isEmpty() ||
                noHpCustomer == null || noHpCustomer.trim().isEmpty() ||
                tanggal == null || jamMulai == null || durasiJam <= 0) {
                throw new Exception("Isi semua data dengan benar!");
            }
            ModelReservasi reservasiedit = new ModelReservasi();

            reservasiedit.setDurasi_jam(durasiJam);
            reservasiedit.setNama_customer(namaCustomer.trim());
            reservasiedit.setNomor_hp_customer(noHpCustomer.trim());
            reservasiedit.setTanggal(new java.sql.Date(tanggal.getTime()));
            reservasiedit.setTipe_studio(tipeStudio);
            reservasiedit.setJam_mulai(jamMulai);
            reservasiedit.setHarga_per_jam(hargaPerJam);

            reservasiedit.hitungJamSelesai();
            reservasiedit.hitungTotalHarga();
            reservasiedit.setId_Reservasi(id);
            
            daoreservasi.update(reservasiedit);
            
            JOptionPane.showMessageDialog(null, createStyledPanel("Berhasil mengupdate reservasi!"), "Sukses", JOptionPane.INFORMATION_MESSAGE);
            
            new ViewReservasi();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error : " + e.getMessage());
        }
    }
    
    public void deleteReservasi(Integer baris){
        try {
            Object idObj = viewreservasi.getTableReservasi().getValueAt(baris, 0);
            int id = Integer.parseInt(idObj.toString());
            String nama = viewreservasi.getTableReservasi().getValueAt(baris, 2).toString();

            int input = JOptionPane.showConfirmDialog(
                    null, 
                    "Hapus reservasi atas nama " + nama + "?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION
            );

            if (input == JOptionPane.YES_OPTION) {
                boolean success = daoreservasi.delete(id);

                if (success) {
                    JOptionPane.showMessageDialog(null, createStyledPanel("Berhasil menghapus reservasi!"), "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    showAll();
                } else {
                    JOptionPane.showMessageDialog(null, createStyledPanel("Gagal menghapus data dari database."), "Gagal", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error saat menghapus: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Getter data
    public List<ModelReservasi> getData() {
        return data;
    }
    
    private JPanel createStyledPanel(String message) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(new Color(220, 53, 69), 2));
        JLabel label = new JLabel("<html><div style='padding:8px;font-size:12px;color:#dc3545;'>" + message + "</div></html>");
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(label);
        return panel;
    }
    
}