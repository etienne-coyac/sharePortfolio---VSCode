
package actions.metier;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

public class ActionComposee extends Action {
    HashMap<ActionSimple, Double> ListActionSimple;
    private String libelle;
    private String nom;
    private String description;

    public ActionComposee(String libelle, String nom, String description) {
        super(libelle,nom,description);
        ListActionSimple = new HashMap<ActionSimple, Double>();
    }


    public void addActionsimple(ActionSimple actionSimple, double pourcentageInsert) throws IllegalArgumentException {
        if (pourcentageInsert > 1.0 || pourcentageInsert <= 0.0) {
            throw new IllegalArgumentException("Le pourcentage ne peut pas être supérieur à 1 ou inférieur à 0");
        }

        if (ListActionSimple.isEmpty()) {
            ListActionSimple.put(actionSimple, 1.0d);
            return;
        }

        if (ListActionSimple.containsKey(actionSimple)) {
            throw new IllegalArgumentException("L'action existe déjà dans la liste");
        }


        for (ActionSimple actionSimple1 : ListActionSimple.keySet()) {
            ListActionSimple.put(actionSimple1, newPourcentageInsert(pourcentageInsert, ListActionSimple.get(actionSimple1)));
        }
        ListActionSimple.put(actionSimple, pourcentageInsert);
    }


    public void removeActionsimple(ActionSimple actionSimple) throws IllegalArgumentException {
        if(!ListActionSimple.containsKey(actionSimple)) {
            throw new IllegalArgumentException("L'action n'existe pas dans la liste");
        }

        double pourcentageToRemove = ListActionSimple.get(actionSimple);
        ListActionSimple.remove(actionSimple);
        for (ActionSimple actionSimple1 : ListActionSimple.keySet()) {
            ListActionSimple.put(actionSimple1, newPourcentageRemove(pourcentageToRemove, ListActionSimple.get(actionSimple1)));
        }
    }

    private double newPourcentageInsert (double pourcentageInsert, double actualPourcentage) {
        double newPourcentage = actualPourcentage * (1.0d - pourcentageInsert);
        return newPourcentage;
    }

    private double newPourcentageRemove (double pourcentageInsert, double actualPourcentage) {
        double newPourcentage = actualPourcentage / (1.0d - pourcentageInsert);
        return newPourcentage;
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

    
    // public void updatePourcentage(ActionSimple actionSimple, double newPourcentage) {
    //     if (!ListActionSimple.containsKey(actionSimple)) {
    //         throw new IllegalArgumentException("L'action n'existe pas dans la liste");
    //     }

    //     if (newPourcentage > 1.0 || newPourcentage <= 0.0) {
    //         throw new IllegalArgumentException("Le pourcentage ne peut pas être supérieur à 1 ou inférieur à 0");
    //     }

        
        
    //     System.out.println("size " + ListActionSimple.size());
    //     for (ActionSimple actionSimple1 : ListActionSimple.keySet()) {
    //         if (!actionSimple1.equals(actionSimple)) {
    //             ListActionSimple.put(actionSimple1, ListActionSimple.get(actionSimple1) * (1.0d - newPourcentage) / (1.0d - ListActionSimple.get(actionSimple)));
    //             System.out.println("action simple : " + actionSimple1.getLibelle());
    //             System.out.println("pourcentage : " + ListActionSimple.get(actionSimple1));
    //         }
    //     }

    //     ListActionSimple.put(actionSimple, newPourcentage);
            
    // }

    public HashMap<ActionSimple, Double> getListActionSimple() {
        return ListActionSimple;
    }



}
