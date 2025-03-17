
package actions.metier;

import java.math.BigDecimal;
import java.util.HashMap;

public class ActionComposee extends Action {
    private HashMap<ActionSimple, BigDecimal> ListActionSimple;
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
    

    public void getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void getDescription() {
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

    public void getValeur(Date date) {
        //ici on va calculer la valeur de l'action composée
        //faut implémenter la méthode getValeurByDate dans ActionSimple/cours
        BigDecimal valeur = new BigDecimal(0);
        for (ActionSimple actionSimple : ListActionSimple.keySet()) {
            valeur = valeur.add(actionSimple.getValeur(date).multiply(ListActionSimple.get(actionSimple)));
        }
        return valeur;
    }

    






}
