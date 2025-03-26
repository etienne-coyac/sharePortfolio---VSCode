
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
     * Attribut représentant le solde du portefeuille.
     */
    private double solde;

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

        this.solde = 0;
    }

    /**
     * Alimente le solde du portefeuille
     */
    public void alimenterPortefeuille(double montant) {
        this.solde += montant;
    }

    /**
     * Renvoie le montant du solde du portefeuille
     */
    public double getSolde() {
        return solde;
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
     * Suppression d'une action présente dans la liste
     * 
     * @param act L'action a été enregistrée
     */
    public void removeAction(Action act) {
        if (act != null) {
            this.listeActions.remove(act);
        }
    }

    /**
     * Vérification si la liste est vide
     * 
     * @return true si la liste est vide
     */
    public boolean isEmpty() {
        List<Action> liste = getListeActions();
        return liste.isEmpty();
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + identifiant;
        result = prime * result + ((listeActions == null) ? 0 : listeActions.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Portefeuille other = (Portefeuille) obj;
        if (identifiant != other.identifiant)
            return false;
        if (listeActions == null) {
            if (other.listeActions != null)
                return false;
        } else if (!listeActions.equals(other.listeActions))
            return false;
        return true;
    }
    /**
     * Réinitialise le compteur d'identifiant (pour tous les catalogues instanciés)
     */
    public static void resetIdCompteur(){
        Portefeuille.compteur = 0;
    }
    
}
