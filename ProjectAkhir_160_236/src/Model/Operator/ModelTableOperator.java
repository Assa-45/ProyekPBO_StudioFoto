package Model.Operator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTableOperator extends AbstractTableModel{
    List<ModelOperator> daftarOperator;
    
    String kolom[] = {"usename", "password", "nama_lengkap", "email"};
    public ModelTableOperator (List<ModelOperator> daftarOperator) {
        this.daftarOperator = daftarOperator;
    }
    
     @Override
    public int getRowCount() {
        return daftarOperator.size();
    }
    
    @Override
    public int getColumnCount() {
        return kolom.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarOperator.get(rowIndex).getUsername();
            case 1:
                return daftarOperator.get(rowIndex).getPassword();
            case 2:
                return daftarOperator.get(rowIndex).getNama_lengkap();
            case 3:
                return daftarOperator.get(rowIndex).getEmail(); 
            default:
                return null;
        }
    }
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}
