package Giocattolaio;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Giocattolo g1 = new Giocattolo("bambola",20,3);
        Giocattolo g2 = new Giocattolo("pistola d'acqua", 15,3);
        Giocattolo g3 = new Giocattolo("overboard", 130, 10);
        Giocattolo g4 = new Giocattolo("macchinina", 10, 8);

        int ritorno;

        Inventario inventario = new Inventario();
        ArrayList <Giocattolo> acquisti = new ArrayList<Giocattolo>();


        inventario.aggiungiGiocattolo(g1);
        inventario.aggiungiGiocattolo(g2);
        inventario.aggiungiGiocattolo(g3);
        inventario.aggiungiGiocattolo(g4);

        //registrazione - login;
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci mail: ");
        String mail = input.nextLine();
        System.out.print("Inserisci nome: ");
        String nome = input.nextLine();
        Cliente c1 = new Cliente(nome,mail);
        if((mail.equals("admin@gamil.com")) && (nome.equals("admin"))){

            //menu per admin
            do{
                ritorno = Interfaccia.richiediMetodo(inventario,c1);

            }while(ritorno > 0);

        }else{

            do{
                ritorno = Interfaccia.metodiCliente(inventario,c1,acquisti);
            }while(ritorno > 0);


            
        }
        System.out.println("Hello MAIN!");
    }  
}
