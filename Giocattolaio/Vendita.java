package Giocattolaio;

public class Vendita {
    
    public static int idProgeressivo = 1;
    public String vendita= "";
    int id;
    Giocattolo g;
    Cliente p;

    public Vendita(Giocattolo g, Cliente p){
        this.g = g;
        this.p = p;
        idProgeressivo++;
    }

    @Override
    public String toString(){
        return idProgeressivo + " vendita: " + p + " ha comprato " + g;
    }
}