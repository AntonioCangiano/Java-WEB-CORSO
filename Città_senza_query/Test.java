package Città_senza_query;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------------------------------");

        Connessione connessione = new Connessione();
        Connection conn = connessione.openConnection();

        // Verifica se la connessione è stata aperta correttamente prima di eseguire l'inserimento
        if (conn != null) {
            connessione.eseguiInsert(conn, "Trapani");
            connessione.eseguiAggiornamento(conn, "Catania", "Caltanissetta");
            connessione.eseguiSelect(conn);
            connessione.closeConnection(conn);
        }
    }
}