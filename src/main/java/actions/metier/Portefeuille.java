
package actions.metier;

import java.util.List;
import java.util.ArrayList;

/**
 * Classe Portefeuille pour stocker toutes les actions.
 */
public class Portefeuille {
    /**
     * Compteur statique pour générer un identifiant unique à la création de chaque portefeuille.
     */
    private static int compteur = 0;

    private final int identifiant;
    /**
     * Attribut représentant une liste d'actions.
     */
    List<Action> listeActions; 

    /**
     * Constructeur de la classe Portefeuille
     * 
     * @param id Le portefeuille à initialiser
     */
    public Portefeuille() {
        /**
         * Incrémente l'identifiant
         */
        this.identifiant = ++compteur;
        /**
         *  Initialise la liste d'actions à vide
         */
        listeActions = new ArrayList<>();
    }

    /**
     * Retourne la liste d'actions du portefeuilles
     * 
     * @return La liste d'actions sous forme de liste
     */
    public List<Action> getListeActions() {
        return listeActions;
    }

    
    /**
     * Ajout d'une action dans la liste
     * 
     * @param act L'action a été enregistrée
     */
    public void addAction(Action act) {
        if (act != null) {
            this.listeActions.add(act);
        }
    }

    /**
     * Retourne l'identifiant du portefeuille
     * 
     * @return L'identifiant sous forme d'entier
     */
    public int getIdentifiant() {
        return identifiant;
    }

    @Override
    public String toString() {
        return "Portefeuille [identifiant=" + identifiant + ", listeActions=" + listeActions + "]";
    }
    
}
