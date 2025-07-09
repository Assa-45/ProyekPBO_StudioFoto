package Model;

import java.sql.*;

public class Connector {
    private static String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    private static String nama_db = "studio_photo";
    private static String url_db = "jdbc:mysql://localhost:3306/" + nama_db + "?autoReconnect=true&useSSL=false";
    private static String username_db = "root";
    private static String password_db = "";

    static Connection conn;

    public static Connection Connect() {
        try {
            Class.forName(jdbc_driver);
            conn = DriverManager.getConnection(url_db, username_db, password_db);
            System.out.println("MySQL Connected");
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Connection Failed: " + exception.getLocalizedMessage());
        }
        return conn;
    }

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed() || !conn.isValid(2)) {
                conn = Connect();
            }
        } catch (SQLException e) {
            System.out.println("Reconnection Failed: " + e.getMessage());
            conn = Connect(); // Paksa reconnect jika error saat pengecekan
        }
        return conn;
    }
}
