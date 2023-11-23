package Città_italiane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class connessione {
    
    public String DB_url = "jdbc:mysql://localhost:3306/world";
    public String DB_driver = "com.mysql.cj.jdbc.Driver";
    public String DB_username = "root";
    public String DB_password ="root";

    public Connection openConnection() {
        Connection conn = null;

        try {
            Class.forName(DB_driver);
            conn = DriverManager.getConnection(DB_url, DB_username, DB_password);
            System.out.println("Connessione riuscita");

            PreparedStatement stmt = null;
            ResultSet rs = null;

            // Query Prova
            String query = "SELECT * FROM città";

            try {
                stmt = conn.prepareStatement(query);
                rs = stmt.executeQuery();

                // Esempio di utilizzo dei dati
                while (rs.next()) {
                    System.out.println("--------------------");
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        System.out.print(rs.getMetaData().getColumnName(i) + ": " + rs.getString(i) + " ");
                    }
                    System.out.println();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

            return conn;
    }

    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connessione chiusa");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}