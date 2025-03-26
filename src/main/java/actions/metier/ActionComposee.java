
package actions.metier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ActionComposee extends Action {
    HashMap<ActionSimple, Double> listActionSimple;
    private String libelle;
    private String nom;
    private String description;

    public ActionComposee(String libelle, String nom, String description) {
        super(libelle,nom,description);
        listActionSimple = new HashMap<ActionSimple, Double>();
    }


    public void addActionsimple(ActionSimple actionSimple, double pourcentageInsert) throws IllegalArgumentException {
        if (pourcentageInsert > 1.0 || pourcentageInsert <= 0.0) {
            throw new IllegalArgumentException("Le pourcentage ne peut pas être supérieur à 1 ou inférieur à 0");
        }

        if (listActionSimple.isEmpty()) {
            listActionSimple.put(actionSimple, 1.0d);
            return;
        }

        if (listActionSimple.containsKey(actionSimple)) {
            throw new IllegalArgumentException("L'action existe déjà dans la liste");
        }


        for (Map.Entry<ActionSimple, Double> entry : listActionSimple.entrySet()) {
            entry.setValue(newPourcentageInsert(pourcentageInsert, entry.getValue()));
        }
        listActionSimple.put(actionSimple, pourcentageInsert);

    }


    public void removeActionsimple(ActionSimple actionSimple) throws IllegalArgumentException {
        if(!listActionSimple.containsKey(actionSimple)) {
            throw new IllegalArgumentException("L'action n'existe pas dans la liste");
        }

        double pourcentageToRemove = listActionSimple.get(actionSimple);
        listActionSimple.remove(actionSimple);
        for (Map.Entry<ActionSimple, Double> entry : listActionSimple.entrySet()) {
            entry.setValue(newPourcentageRemove(pourcentageToRemove, entry.getValue()));
        }
        
    }

    private double newPourcentageInsert (double pourcentageInsert, double actualPourcentage) {
        return actualPourcentage * (1.0d - pourcentageInsert);
    }

    private double newPourcentageRemove (double pourcentageInsert, double actualPourcentage) {
        return actualPourcentage / (1.0d - pourcentageInsert);
    }


    //waiting for the implementation of getValeurByDate in ActionSimple
    public double calculerValeurDate(Date date) {
        //ici on va calculer la valeur de l'action composée
        //faut implémenter la méthode getValeurByDate dans ActionSimple/cours
        Double valeur = 0.0;
        for (ActionSimple actionSimple : listActionSimple.keySet()) {
            // valeur = valeur.add(actionSimple.getValeur(date).multiply(ListActionSimple.get(actionSimple)));
        }
        return valeur;
    }

    
    public void updatePourcentage(ActionSimple actionSimple, double newPourcentage) {
        if (!listActionSimple.containsKey(actionSimple)) {
            throw new IllegalArgumentException("L'action n'existe pas dans la liste");
        }

        if (newPourcentage > 1.0 || newPourcentage <= 0.0) {
            throw new IllegalArgumentException("Le pourcentage ne peut pas être supérieur à 1 ou inférieur à 0");
        }

        
        
        double denominator = 1.0d - listActionSimple.get(actionSimple); // 预先计算分母，避免重复计算

        for (Map.Entry<ActionSimple, Double> entry : listActionSimple.entrySet()) {
            if (!entry.getKey().equals(actionSimple)) {
            entry.setValue(entry.getValue() * (1.0d - newPourcentage) / denominator);
            }
        }


        listActionSimple.put(actionSimple, newPourcentage);
            
    }

    public Map<ActionSimple, Double> getListActionSimple() {
        return listActionSimple;
    }

    @Override
    public String toString() {
        return "ActionComposee [ " + libelle + " : nom=" + nom + ", description=" + description + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ActionComposee)) {
            return false;
        }
        ActionComposee actionComposee = (ActionComposee) o;
        return actionComposee.getLibelle().equals(libelle);
    }

}
