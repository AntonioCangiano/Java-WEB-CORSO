package Giocattolaio;

public class Cliente {
    int idIncrementato = 1;
    int id;
    private String nome;
    private String mail;

    public Cliente(String nome, String mail){
        if(!(nome.equals("")) && !(mail.equals(""))){

            this.nome = nome;
            this.mail = mail;
            this.id = idIncrementato++;
        }else{
            System.out.println("Almeno uno dei campi è vuoto. ");
        }
    }

    public int getId(){
        return id;
    }

    
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getMail(){
        return mail;
    }

    public void setMail(String mail){
        this.mail = mail;
    }
    

    @Override
    public String toString(){
        return nome + " " + mail + " " + id;
    }
}