package Giocattolaio;

public class Giocattolo {
    private int id;
    private String nome;
    private double prezzo;
    private String etaConsigliata;

    public Giocattolo(int id, String nome, double prezzo, String etaConsigliata) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.etaConsigliata = etaConsigliata;
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

    // Getter per il prezzo
    public double getPrezzo() {
        return prezzo;
    }

    // Setter per il prezzo
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    // Getter per l'età consigliata
    public String getEtaConsigliata() {
        return etaConsigliata;
    }

    // Setter per l'età consigliata
    public void setEtaConsigliata(String etaConsigliata) {
        this.etaConsigliata = etaConsigliata;
    }
}

