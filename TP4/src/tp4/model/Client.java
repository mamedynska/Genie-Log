package tp4.model;

import java.util.ArrayList;
import java.util.List;

public class Client{
    private String nom;
    private String paiement;
    private String contact;
    private String reference;
    private List<Reservation> reservations = new ArrayList<>();

    public Client(String n, String p, String c, String r, List<Reservation> lr){
        if(n == null || p == null || c == null || r == null ) {
        	throw new IllegalArgumentException("Information(s) sur le client manquante(s)");
        }
        nom = n;
        paiement = p;
        contact = c;
        reference= r;
        reservations= lr;
    }

    @Override
    public String toString() {
        String mess = "CLIENT\n";
        mess += "   Nom : " + nom.toString()+"\n";
        mess += "   Paiement : "+paiement.toString()+"\n";
        if(reservations==null){
            mess += "   Reservation : null \n";
        }
        else{
            mess += "   Reservation : "+reservations.toString();
        }
        return mess;
    }
    
    public String toStringName(){
        return nom;
    }

    public void afficher() {
        System.out.println(this.toString());
    }
}