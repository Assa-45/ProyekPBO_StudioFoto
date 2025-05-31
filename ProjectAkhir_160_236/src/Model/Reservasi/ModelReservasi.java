package Model.Reservasi;
import java.sql.Time;
import java.sql.Date;
import java.util.Calendar;

public class ModelReservasi {
    private Date tanggal;
    private Time jam_mulai;
    private int durasi_jam;
    private double total_harga;
    private int id_studio;
    private int id_operator;
    private int id_customer;
    private Time jam_selesai;
    
    //tanggal
    public void setTanggal(Date tanggal){
        this.tanggal = tanggal;
    }
    public Date getTanggal(){
        return tanggal;
    }
    
    //Jam Mulai
    public void setJam_mulai(Time jam_mulai) {
        this.jam_mulai = jam_mulai;
        hitungJamSelesai(); // otomatis hitung
    }
    public Time getJam_mulai(){
        return jam_mulai;
    }
    
    //Durasi Jam
    public void setDurasi_jam(int durasi_jam) {
        this.durasi_jam = durasi_jam;
        hitungJamSelesai(); // otomatis hitung
    }
    public int getDurasi_jam(){
        return durasi_jam;
    }
    
    //Total Harga
    public void setTotal_harga(double total_harga){
        this.total_harga = total_harga;
    }
    public double getTotal_harga(){
        return total_harga;
    }
    
    // Tambahan: method untuk menghitung total_harga otomatis
    public void hitungTotal_harga(String tipe) {
    double  harga_per_jam = 0;

    switch (tipe.toLowerCase()) {
        case "large":
            harga_per_jam = 100_000;
            break;
        case "medium":
             harga_per_jam = 75_000;
            break;
        case "small":
             harga_per_jam = 50_000;
            break;
        default:
            throw new IllegalArgumentException("Tipe studio tidak valid: " + tipe);
    }

    this.total_harga =  harga_per_jam * durasi_jam;
}
    
    //id_studio
    public void setId_studio(int id_studio){
        this.id_studio = id_studio;
    }
    public int getId_studio(){
        return id_studio;
    }
    
    //id_operator
    public void setId_operator(int id_operator){
        this.id_operator = id_operator;
    }
    public int getId_operator(){
        return id_operator;
    }
    
    //id_cutomer
    public void setId_customer(int id_customer){
        this.id_customer = id_customer;
    }
    public int getId_customer(){
        return id_customer;
    }
    
    //Jam Selesai
    public Time getJamSelesai() {
        return jam_selesai;
    }
    private void hitungJamSelesai() {
        if (jam_mulai != null && durasi_jam > 0) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(jam_mulai);
            cal.add(Calendar.HOUR_OF_DAY, durasi_jam);
            this.jam_selesai = new Time(cal.getTimeInMillis());
        }
    }
    public Time getJam_selesai(){
        return jam_selesai;
    }
    
}
