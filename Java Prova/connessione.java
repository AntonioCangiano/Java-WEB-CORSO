import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class connessione {
    
    public String DB_url = "jdbc:mysql://localhost:3306/scuola";
    public String DB_driver = "com.mysql.cj.jdbc.Driver";
    public String DB_username = "root";
    public String DB_password ="root";



    /**
     * 
     */
    public void openConnection(){
        Connection conn = null; 
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName(DB_driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_url, DB_username, DB_password);
            if (conn!= null) {
                System.out.println("connessione riuscita");

                //Query Prova
                String query=   "Insert into persona (nome) values ('prova')";
                stmt = conn.prepareStatement(query);

                // Esecuzione della query
                rs = stmt.executeQuery();

            
                // Elaborazione dei risultati
                while (rs.next()) { 
                    // Recupera i dati dalla riga corrente
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");

                    // Esempio di utilizzo dei dati
                    System.out.println("ID: " + id + ", Nome: " + nome);
                }
                

            }else{
                System.out.println("connessione non riuscita");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            if (conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}