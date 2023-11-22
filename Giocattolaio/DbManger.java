package Giocattolaio;

/*import java.sql.*;

public class DbManger {
    public String DB_url = "jdbc:mysql://localhost:3306/";
    public String DB_driver = "com-mysql•jdbc.Driver";
    public String DB_username = "root"; 
    public String DB_password = "root";

    public void openConnection(){
        Connection conn = null;
        try{
            Class.forName(DB_driver);
            conn = DriverManager.getConnection(DB_url, DB_username, DB_password);
            System.out.println("Connessione al database avvenuta con successo!");
        }catch(Exception e){
            System.out.println("Errore di connessione al database!");
        }
        finally{
            try{
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                System.out.println("Errore di chiusura della connessione al database!");
                e.printStackTrace();
            }
        }

    }
}*/


import java.sql.*;
import javax.swing.*;
public class DbManger {
    //Connection conn=null;
    public static Connection ConnectDB(){

        String url = "jdbc:mysql://localhost:3306/utenti";
        String username = "root";
        String password = "root";

        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
            //connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }        
    }
     public static void main(String args[]) {
        Connection conn=ConnectDB();
        
        String query = "INSERT INTO utente (nome, email, password) VALUES ('Antonio Cangiano', 'a.cangiano04@gmail.com', 'root')";

        try (Statement st = conn.prepareStatement(query)) {
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Utente inserito correttamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
