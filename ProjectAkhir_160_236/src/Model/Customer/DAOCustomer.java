package Model.Customer;
import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOCustomer {
    public void insert (ModelCustomer customer) {
    try{
        String query = "INSERT INTO customer (nama, nomor_hp) VALUES (?, ?)";
        
        PreparedStatement statement;
        statement = Connector.Connect().prepareStatement(query);
        statement.setString(1, customer.getNama());
        statement.setString(2, customer.getNomor_hp());
        
        statement.executeUpdate();
        statement.close();
    } catch (SQLException e){
        System.out.println("Input Failed " + e.getLocalizedMessage());
    }
    }
}
