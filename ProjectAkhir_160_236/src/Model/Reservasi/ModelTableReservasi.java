package Model.Reservasi;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTableReservasi extends AbstractTableModel{
    List<ModelReservasi> daftarReservasi;
    
    String kolom[] = {"tanggal", "jam_mulai", "durasi_jam", 
        "total_harga", "id_studio", "id_operator", "id_customer", "jam_selesai"};
    public ModelTableReservasi (List<ModelReservasi> daftarReservasi) {
        this.daftarReservasi = daftarReservasi;
    }
    
     @Override
    public int getRowCount() {
        return daftarReservasi.size();
    }
    
    @Override
    public int getColumnCount() {
        return kolom.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarReservasi.get(rowIndex).getTanggal();
            case 1:
                return daftarReservasi.get(rowIndex).getJam_mulai();
            case 2:
                return daftarReservasi.get(rowIndex).getDurasi_jam();
            case 3:
                return daftarReservasi.get(rowIndex).getTotal_harga();
            case 4:
                return daftarReservasi.get(rowIndex).getId_studio();
            case 5:
                return daftarReservasi.get(rowIndex).getId_operator();
            case 6:
                return daftarReservasi.get(rowIndex).getId_customer();
            case 7:
                return daftarReservasi.get(rowIndex).getJam_selesai();
            default:
                return null;
        }
    }
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}