import java.time.ZonedDateTime;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        try{
            Client clientDo = new Client("Dodorina", "PayPal", "0605663565", "Beau", null);
            Passager p1 = new Passager("Dorian", "0605663565");
            Passager p2 = new Passager("Max", "0605213506");
            Vol v1 = new Vol("V001",null, null);
            v1.ouvrir();
            ArrayList<Passager> lp = new ArrayList<Passager>();
            lp.add(p1);
            Reservation r1 = new Reservation("R001", v1, lp, clientDo);
            Reservation r2 = new Reservation("id", v1, lp, clientDo);


            System.out.println("Client : ");
            clientDo.afficher();
            System.out.println("V1 :");
            v1.afficher();
            // r1.afficher();
            System.out.println("Reservation : ");
            r2.afficher();
            try {
                r2.payer();
                r2.afficher();
                r2.confirmer();
                r2.afficher();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
          
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //TODO : Test unitaire + vérifier build
}