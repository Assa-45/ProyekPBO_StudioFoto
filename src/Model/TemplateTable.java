package Model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TemplateTable<Temp> extends AbstractTableModel {
    private List<Temp> daftarReservasi;
    private String[] kolom;
    private DataExtractor<Temp> extractor;
    
    // konstruktor baka nerima daftar data dan kolom
    public TemplateTable(List<Temp> daftarReservasi, String[] kolom, DataExtractor<Temp> extractor){
        this.daftarReservasi = daftarReservasi;
        this.extractor = extractor;
        this.kolom = kolom;
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
        return extractor.getValue(daftarReservasi.get(rowIndex), columnIndex);
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return kolom[columnIndex];
    }
}
