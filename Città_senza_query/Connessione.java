package Città_senza_query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class Connessione {

    public String DB_url = "jdbc:mysql://localhost:3306/world";
    public String DB_driver = "com.mysql.cj.jdbc.Driver";
    public String DB_username = "root";
    public String DB_password = "root";

    public Connection openConnection() {
        Connection conn = null;

        try {
            Class.forName(DB_driver);
            conn = DriverManager.getConnection(DB_url, DB_username, DB_password);
            System.out.println("Connessione riuscita");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void eseguiInsert(Connection conn, String nomeCitta) {
        try {
            String query = "INSERT INTO città (Nome) VALUES (?)";

            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, nomeCitta);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println(rowsAffected + " righe inserite con successo.");
                } else {
                    System.out.println("Nessuna riga inserita. Potrebbe già esistere una città con lo stesso nome.");
                }
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Violazione del vincolo di chiave primaria. Potrebbe già esistere una città con lo stesso nome.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eseguiAggiornamento(Connection conn, String nomeCittaAttuale, String nuovoNomeCitta) {
        try {
            String query = "UPDATE città SET Nome = ? WHERE Nome = ?";
    
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, nuovoNomeCitta);
                preparedStatement.setString(2, nomeCittaAttuale);
    
                int rowsAffected = preparedStatement.executeUpdate();
    
                if (rowsAffected > 0) {
                    System.out.println(rowsAffected + " righe aggiornate con successo.");
                } else {
                    System.out.println("Nessuna riga aggiornata. Potrebbe non esistere una città con il nome specificato.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eseguiSelect(Connection conn){

        ResultSet rs = null;
        try {
            String query = "SELECT * FROM città";

            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.executeQuery();
                rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    System.out.println("--------------------");
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        System.out.print(rs.getMetaData().getColumnName(i) + ": " + rs.getString(i) + " ");
                    }
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eseguiEliminazione(Connection conn, String nomeCitta) {
        try {
            String query = "DELETE FROM città WHERE Nome = ?";
    
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, nomeCitta);
    
                int rowsAffected = preparedStatement.executeUpdate();
    
                if (rowsAffected > 0) {
                    System.out.println(rowsAffected + " righe eliminate con successo.");
                } else {
                    System.out.println("Nessuna riga eliminata. Potrebbe non esistere una città con il nome specificato.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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