package Model.Operator;
import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOOperator {
    public void insert (ModelOperator operator) {
    try{
        String query = "INSERT INTO operator (username, password, nama_lengkap, email) VALUES (?, ?, ?, ?)";
        
        PreparedStatement statement;
        statement = Connector.Connect().prepareStatement(query);
        statement.setString(1, operator.getUsername());
        statement.setString(2, operator.getPassword());
        statement.setString(3, operator.getNama_lengkap());
        statement.setString(4, operator.getEmail());
        
        statement.executeUpdate();
        statement.close();
    } catch (SQLException e){
        System.out.println("Input Failed " + e.getLocalizedMessage());
    }
    }
}
