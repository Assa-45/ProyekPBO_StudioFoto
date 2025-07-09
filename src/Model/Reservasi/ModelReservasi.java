package Model.Reservasi;

import ModelMenu.StatusType;
import java.sql.Time;
import java.sql.Date;
import java.util.Calendar;

public class ModelReservasi {
    private int id_Reservasi;
    private Date tanggal;
    private Time jam_mulai;
    private int durasi_jam;
    private double total_harga;
    private Time jam_selesai;
    private String nama_customer;
    private String nomor_hp_customer;
    private String tipe_studio;
    private double harga_per_jam;
    private StatusType status;

    // Constructor lengkap
    public ModelReservasi(
        String id_reservasi,
        String nama_customer,
        String nomor_hp_customer,
        Date tanggal,
        String tipe_studio,
        double harga_per_jam,
        Time jam_mulai,
        int durasi_jam,
        double total_harga,
        StatusType status
    ) {
        this.nama_customer = nama_customer;
        this.nomor_hp_customer = nomor_hp_customer;
        this.tanggal = tanggal;
        this.tipe_studio = tipe_studio;
        this.harga_per_jam = harga_per_jam;
        this.jam_mulai = jam_mulai;
        this.durasi_jam = durasi_jam;
        this.total_harga = total_harga;
        this.status = status;
        
    }

    public ModelReservasi() {
        
    }
    
    // id_Reservasi
    public int getId_Reservasi() {
        return id_Reservasi;
    }
    public void setId_Reservasi(int id_Reservasi) {
        this.id_Reservasi = id_Reservasi;
    }

    // tanggal
    public void setTanggal(Date tanggal){
        this.tanggal = tanggal;
    }
    public Date getTanggal(){
        return tanggal;
    }

    // jam_mulai
    public void setJam_mulai(Time jam_mulai) {
        this.jam_mulai = jam_mulai;
    }
    public Time getJam_mulai(){
        return jam_mulai;
    }

    // durasi_jam
    public void setDurasi_jam(int durasi_jam) {
        this.durasi_jam = durasi_jam;
    }
    public int getDurasi_jam(){
        return durasi_jam;
    }

    // total_harga
    public void setTotal_harga(double total_harga){
        this.total_harga = total_harga;
    }
    public double getTotal_harga(){
        return total_harga;
    }

    // jam_selesai
    public Time getJam_selesai(){
        return jam_selesai;
    }
    
    public void setJam_selesai(Time jam_selesai){
        this.jam_selesai = jam_selesai;
    }
    
    public void hitungJamSelesai() {
        if (jam_mulai != null && durasi_jam > 0) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(jam_mulai);
            cal.add(Calendar.HOUR_OF_DAY, durasi_jam);
            this.jam_selesai = new Time(cal.getTimeInMillis());
        }
    }

    // nama_customer
    public void setNama_customer(String nama_customer) {
        this.nama_customer = nama_customer;
    }
    public String getNama_customer() {
        return nama_customer;
    }

    // nomor_hp_customer
    public void setNomor_hp_customer(String nomor_hp_customer) {
        this.nomor_hp_customer = nomor_hp_customer;
    }
    public String getNomor_hp_customer() {
        return nomor_hp_customer;
    }


    // tipe_studio
    public void setTipe_studio(String tipe_studio) {
        this.tipe_studio = tipe_studio;
    }
    public String getTipe_studio() {
        return tipe_studio;
    }

    // harga_per_jam
    public void setHarga_per_jam(double harga_per_jam) {
        this.harga_per_jam = harga_per_jam;
    }
    
    public double getHarga_per_jam() {
        return harga_per_jam;
    }

    // status
    public void setStatus(StatusType status) {
        this.status = status;
    }
    public StatusType getStatus() {
        return status;
    }

    // hitung total_harga otomatis
    public void hitungTotalHarga() {
        this.total_harga = harga_per_jam * durasi_jam;
    }
}
