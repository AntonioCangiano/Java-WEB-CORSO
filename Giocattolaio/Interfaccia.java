package Giocattolaio;

import java.util.ArrayList;
import java.util.Scanner;

public class Interfaccia {

    //menu cliente
    public static int richiediMetodo(Inventario inventario, Cliente cliente){
        Scanner input = new Scanner(System.in);
        int scelta;
        int ritorno = 1;

        //registrazione / login
        System.out.println("");
        System.out.println("Ciao " + cliente.getNome());

        System.out.println("");
        System.out.println("1: aggiungi giocattolo");
        System.out.println("2: rimuivi giocattolo");
        System.out.println("3: stampa ordini");
        System.out.println("4: esci dal programma");
        System.out.print("Scegli la funzione > ");
        scelta = input.nextInt();
        input.nextLine();

        //menu admin
        switch(scelta){

            case 1:
                String nome;
                int prezzo,etàConsigliata;
                System.out.print("Inserisci il nome del nuovo giocattolo: ");
                nome = input.nextLine();
                // input.nextInt(); reset del buffer

                System.out.print("Inserisci prezzo: ");
                prezzo = input.nextInt();

                System.out.print("inserisci l età consigliata: ");
                etàConsigliata = input.nextInt();

                Giocattolo g1 = new Giocattolo(nome,prezzo,etàConsigliata);
                inventario.aggiungiGiocattolo(g1);
                System.out.println("Oggetto aggiunto con successo! ");
                ritorno = 1;
            break;

            case 2:
                System.out.println("ricerca per id: ");
                int id;
                id = input.nextInt();
                for(int i = 0 ; i < inventario.listaGiocattoli.size() ; i++){
                    if(inventario.listaGiocattoli.get(i).getId() == id){
                        inventario.listaGiocattoli.remove(i);
                        System.out.println("Giocattolo rimosso con successo. ");
                    }else{
                        System.out.println("Giocattolo non trovato. ");
                    }
                }
                ritorno = 1;                

             break;
             
              case 3:
                System.out.println("Stampo tutti gli elementi");
                for(int i = 0 ; i < inventario.listaGiocattoli.size(); i++){
                    System.out.println(inventario.listaGiocattoli.get(i));
                }
                
             ritorno = 1;
             break;

             case 4:
                System.out.println("esco dal programma");
                ritorno = -1;
                break;


        }

        return ritorno;


    }

    //menu cliente
    public static int metodiCliente(Inventario inventario, Cliente cliente, ArrayList<Giocattolo> acquisti){
        int ritorno = 0;
        Scanner input = new Scanner(System.in);



        System.out.println("1 > Acquista Giocattolo ( per id)");
        System.out.println("2 > visualizza tutti i Giocattoli");
        System.out.println("3 > visualizza gli acquisti fatti ");
        System.out.print("scegli la funzione: ");

        int scelta;
        scelta = input.nextInt();

        switch(scelta){
            case 1:
            int id;
            System.out.print("Inserisci id dell oggetto da coprare: ");
            id = input.nextInt();
                for(int i = 0; i < inventario.listaGiocattoli.size() ; i++){
                    if(inventario.listaGiocattoli.get(i).getId() == id){
                        System.out.println("Oggetto acquistato con successo! ");
                        acquisti.add(inventario.listaGiocattoli.get(i));
                        ritorno = 1;

                        continue;
                    }
                }
            break;

            case 2:
            for(int i = 0 ; i < inventario.listaGiocattoli.size() ; i++){
                System.out.println(inventario.listaGiocattoli.get(i));
            }
            ritorno = 1;
            //stampa tutti gli elementi
            break;


            case 3: // stampa acquisti
                System.out.println(cliente.getNome() +  " ha comprato: ");
                for(int i = 0; i < acquisti.size() ; i++){
                    System.out.println(acquisti.get(i));
                }
                ritorno = 1;
                break;

            case 4:
            System.out.println("esco dal programma! ");
            ritorno = -1;

        }



        return ritorno;
    }

    
        
}
