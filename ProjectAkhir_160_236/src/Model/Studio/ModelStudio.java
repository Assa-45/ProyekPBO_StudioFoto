package Model.Studio;

public class ModelStudio {
    private String nama_studio, tipe;
    private double harga_per_jam;
    
    public void setNama_studio(String nama_studio){
        this.nama_studio = nama_studio;
    }
    public String getNama_studio(){
        return nama_studio;
    }
    
    public void setTipe(String tipe){
        this.tipe = tipe;
    }
    public String getTipe(){
        return tipe;
    }
    
    public void setHarga_per_Jam(double harga_per_jam){
        this.harga_per_jam = harga_per_jam;
    }
    public double getHarga_per_jam(){
        return harga_per_jam;
    }
}
