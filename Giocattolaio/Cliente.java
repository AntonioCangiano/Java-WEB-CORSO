package Giocattolaio;
public class Cliente {
    private int id;
    private String nome;
    private String indirizzoEmail;

    public Cliente(int id, String nome, String indirizzoEmail) {
        this.id = id;
        this.nome = nome;
        this.indirizzoEmail = indirizzoEmail;
    }

    // Getter per l'ID
    public int getId() {
        return id;
    }

    // Setter per l'ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter per il nome
    public String getNome() {
        return nome;
    }

    // Setter per il nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter per l'indirizzo email
    public String getIndirizzoEmail() {
        return indirizzoEmail;
    }

    // Setter per l'indirizzo email
    public void setIndirizzoEmail(String indirizzoEmail) {
        this.indirizzoEmail = indirizzoEmail;
    }
}
