package Model.Customer;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTableCustomer extends AbstractTableModel{
    List<ModelCustomer> daftarCustomer;
    
    String kolom[] = {"Nama", "nomor_hp"};
    public ModelTableCustomer (List<ModelCustomer> daftarCustomer) {
        this.daftarCustomer = daftarCustomer;
    }
    
     @Override
    public int getRowCount() {
        return daftarCustomer.size();
    }
    
    @Override
    public int getColumnCount() {
        return kolom.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarCustomer.get(rowIndex).getNama();
            case 1:
                return daftarCustomer.get(rowIndex).getNomor_hp();
            default:
                return null;
        }
    }
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}
