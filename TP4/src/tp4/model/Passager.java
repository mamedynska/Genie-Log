package tp4.model;

public class Passager{
    private String nom;
    private String contact;


    public Passager(String nom, String contact){
        if(nom == null || contact == null) {
        	throw new IllegalArgumentException("Information(s) sur le passager manquante(s)");
        }
    	this.nom=nom;
        this.contact=contact;
    }

    @Override
    public String toString() {
        String mess = "PASSAGER\n";
        mess += "Name : "+nom;
        mess += "Contact : "+ contact;
        return mess;
    }

    public void afficher(){
        System.out.println(this.toString());
    }
}