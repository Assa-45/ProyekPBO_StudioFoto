package Model.Studio;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTableStudio extends AbstractTableModel{
    List<ModelStudio> daftarStudio;
    
    String kolom[] = {"nama_studi", "tipe", "harga_per_jam"};
    public ModelTableStudio (List<ModelStudio> daftarStudio) {
        this.daftarStudio = daftarStudio;
    }
    
     @Override
    public int getRowCount() {
        return daftarStudio.size();
    }
    
     @Override
    public int getColumnCount() {
        return kolom.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarStudio.get(rowIndex).getNama_studio();
            case 1:
                return daftarStudio.get(rowIndex).getTipe();
            case 2:
                return daftarStudio.get(rowIndex).getHarga_per_jam();
            default:
                return null;
        }
    }
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}
