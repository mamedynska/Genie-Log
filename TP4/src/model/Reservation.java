import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Reservation{
    public Date date;
    public String identifiant;
    public String etat;
    public Vol vol;
    public List<Passager> listePassagers = new ArrayList<>();
    public Client client;

    public Reservation(String id, Vol lv, List<Passager> lp, Client c){
        if(lp.size() < 1 ){
            throw new IllegalArgumentException("Il faut au moins un passager");
        }
        if(c == null){
            throw new IllegalArgumentException("Un client doit réserver");
        }
        if(lv == null){
            throw new IllegalArgumentException("Il faut réserver au moins un vol");
        }
        if(!lv.isOpen()){
            throw new IllegalArgumentException("Le vol doit être ouvert à la réservation");
        }
        if(id == null){
            throw new IllegalArgumentException("La réservation doit avoir un ID");
        }
        client = c;
        listePassagers = lp;
        vol = lv;
        date = new Date();
        identifiant = id;
        etat= "CREER";
    }

    public void annuler() throws Exception{
        
        switch (etat) {
            case "PAYER":
                // Déclencer remboursement
                etat = "ANNULER";
                break;

            case "CONFIRMER":
                throw new Exception("Impossible d'annuler aprés confirmation");
                // break;

            case "CREER":
                etat = "ANNULER";
                break;
                
            default:
                break;
        }
    }

    public void confirmer() throws Exception{
        switch (etat) {
            case "PAYER":
                etat = "CONFIRMER";
                break;

            case "CREER":
                throw new Exception("Vous devez d'abors payer");
                // break;

            case "ANNULER":
                throw new Exception("ERREUR : Vous avez annulé votre réservation avant");
                // break;

            default:
                break;
        }
        
    }

    public void payer() throws Exception {
        switch (etat) {
            case "CREER":
                // Vérifier paiment
                etat = "PAYER";
                break;

            case "ANNULER":
                throw new Exception("ERREUR : Vous avez annulé votre réservation avant");
                // break;
            
            case "CONFIRMER":
                throw new Exception("Vous avez déjà payer");
                // break;
        
            case "PAYER":
                throw new Exception("Vous avez déjà payer");
                // break;
        }
    }

    @Override
    public String toString() {
        String mess = "RESERVATION \n";
        mess += "Date : "+date.getDate()+"\n";
        mess += "Identifiant : " + identifiant.toString() + "\n";
        mess += "Etat : "+etat.toString()+"\n";
        mess += "Vol : "+ vol.toString()+"\n";
        mess += "Liste Passager : "+listePassagers.toString()+"\n";
        mess += "Client : "+client.toStringName()+"\n";
        return mess; 
    }

    public void afficher() {
        System.out.println(this.toString());
    }
    
}