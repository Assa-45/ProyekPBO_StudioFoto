package Model.Operator;
import Model.Connector;
import java.sql.*;

public class DAOOperator {
    public boolean insert (ModelOperator operator) {
        try{
            String query = "INSERT INTO operator (username, password, nama_lengkap, email) VALUES (?, ?, ?, ?)";

            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, operator.getUsername());
            statement.setString(2, operator.getPassword());
            statement.setString(3, operator.getNama_lengkap());
            statement.setString(4, operator.getEmail());
            
            boolean isSuccess = statement.executeUpdate() > 0;
            statement.close();
            
            return isSuccess;
        } catch (SQLException e){
            System.out.println("Input Failed " + e.getLocalizedMessage());
            return false;
        }
    }
    
    public boolean validasiLogin(String email, String password) {
        try {
            String query = "SELECT * FROM operator WHERE email = ? AND password = ?";
            PreparedStatement statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            boolean isValid = resultSet.next();

            resultSet.close();
            statement.close();

            return isValid;
        } catch (SQLException e) {
            System.out.println("Login Failed: " + e.getMessage());
            return false;
        }
    }
}
