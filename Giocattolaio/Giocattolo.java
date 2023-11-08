package Giocattolaio;

public class Giocattolo{

    static Integer idProgressivo = 1;
    int id;
    private static String codiceGiocattolo = "";
    String nome;
    private int prezzo;
    private int etàConsigliata;

    public Giocattolo(String nome, int prezzo, int etàConsigliata){
        if( !(nome.equals("")) && (prezzo != 0) && (etàConsigliata != 0 )){
            this.nome = nome;
            this.prezzo = prezzo;
            this.etàConsigliata = etàConsigliata;
            codiceGiocattolo += nome + "_PROD_" + idProgressivo.toString();
            id = idProgressivo++;
        }
    }



    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        if(!(nome.equals(""))){
            this.nome = nome;
        }else{
            System.out.println("nome inserito non valido");
        }
    }

    public int getPrezzo(){
        return prezzo;
    }

    public void setPrezzo(int prezzo){
        if(prezzo != 0){
            this.prezzo = prezzo;
        }else{
            System.out.println("valori inseriti non validi");
        }
    }

    public int getEtàConsigliata(){
        return etàConsigliata;
    }

    public void setEtàConsigliata(int etàConsigliata){
        this.etàConsigliata = etàConsigliata;
    }

    public int getId(){
        return id;
    }
    @Override
    public String toString(){
        return "\t " + nome.toUpperCase() + " € " + prezzo + "\n \t età consigliata è: " + etàConsigliata + " (id: " + id + ") \n";
    }
}