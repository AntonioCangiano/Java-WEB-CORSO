package Giocattolaio;

import java.sql.*;

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
}
