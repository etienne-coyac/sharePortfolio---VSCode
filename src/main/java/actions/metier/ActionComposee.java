
package actions.metier;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

public class ActionComposee extends Action {
    HashMap<ActionSimple, BigDecimal> ListActionSimple;
    private String libelle;
    private String nom;
    private String description;

    public ActionComposee(String libelle, String nom, String description) {
        super(libelle,nom,description);
        ListActionSimple = new HashMap<ActionSimple, BigDecimal>();
    }

    public ActionComposee(){
        super();
        ListActionSimple = new HashMap<ActionSimple, BigDecimal>();
    }
    

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addActionsimple(ActionSimple actionSimple, BigDecimal pourcentage) {
        ListActionSimple.put(actionSimple, pourcentage);
    }

    public void removeActionsimple(ActionSimple actionSimple) {
        ListActionSimple.remove(actionSimple);
    }


    //waiting for the implementation of getValeurByDate in ActionSimple
    public double calculerValeurDate(Date date) {
        //ici on va calculer la valeur de l'action composée
        //faut implémenter la méthode getValeurByDate dans ActionSimple/cours
        Double valeur = 0.0;
        for (ActionSimple actionSimple : ListActionSimple.keySet()) {
            // valeur = valeur.add(actionSimple.getValeur(date).multiply(ListActionSimple.get(actionSimple)));
        }
        return valeur;
    }

    
    public void updatePourcentage(ActionSimple actionSimple, BigDecimal pourcentage) {
        ListActionSimple.put(actionSimple, pourcentage);
    }

    public HashMap<ActionSimple, BigDecimal> getListActionSimple() {
        return ListActionSimple;
    }



}
