package Model;

public interface DataExtractor<T> {
    Object getValue(T data, int columnIndex);
}
