package tp4.model;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Vol {
    private String identifiant;
    private ZonedDateTime depart;
    private ZonedDateTime arrivee;
    private boolean etat;

    public Vol(String id, ZonedDateTime dp, ZonedDateTime ar){
    	if(id == null) {
    		throw new IllegalArgumentException("ID du vol manquant");
        }
    	
    	identifiant = id;
        dp = depart;
        arrivee = ar;
        etat=false;
    }

    public Duration duree() {
        long l = depart.compareTo(arrivee);
        return Duration.ofMinutes(l);
    }
    
    public void ouvrir(){
        etat=true;
    }

    public void fermer(){
        etat=false;
    }

    public boolean isOpen() {
        return etat;
    }

    @Override
    public String toString() {
        String mess="";
        mess += "Identifiant : "+identifiant +"\n";
        if(depart == null){
            mess += "Date de départ : null\n";    
        }
        else{
            mess += "Date de départ : " + depart.getDayOfMonth() + "/" + depart.getMonth() + "/" + depart.getYear()+ " à " + depart.getHour() + "h" + depart.getMinute() + "s" + "\n";
        }
        if (depart == null) {
            mess += "Date d'arrivée : null\n";
        } else {
            mess += "Date d'arrivée : " + arrivee.getDayOfMonth() + "/" + arrivee.getMonth() + "/" + arrivee.getYear()+ " à " + arrivee.getHour() + "h" + arrivee.getMinute() + "s" + "\n";

        }
        mess += "Etat : "+etat+"\n";
        return mess;
    }

    public void afficher() {
        System.out.println(this.toString());
    }

}