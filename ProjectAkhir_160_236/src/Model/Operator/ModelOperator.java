package Model.Operator;

public class ModelOperator {
    private String username, password, nama_lengkap, email;
    
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    
    public void setNama_lengkap(String nama_lengkap){
        this.nama_lengkap = nama_lengkap;
    }
    public String getNama_lengkap(){
        return nama_lengkap;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
}
