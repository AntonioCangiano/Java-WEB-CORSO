package Giocattolaio;

import java.util.ArrayList;

public class Inventario {
    
    ArrayList <Giocattolo> listaGiocattoli = new ArrayList<Giocattolo>();
    String mailAdmin = "admin@gmail.com";
    String nomeAdmin = "admin";

    

    public void aggiungiGiocattolo(Giocattolo g){
        listaGiocattoli.add(g);
    }

    public void rimuoviGiocattolo(Giocattolo g){
       for(int i = 0 ; i < listaGiocattoli.size() ; i ++){
            if(listaGiocattoli.get(i).getId() == g.getId()){
                listaGiocattoli.remove(i);

            }
       }
    }
    
    public void stampaElementi(){
        for(int i = 0 ; i < listaGiocattoli.size() ; i++){
            System.out.println("elemento " + i + " " + listaGiocattoli.get(i));
        }
    }

}