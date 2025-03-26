package actions.metier;

import java.util.Date;

/**
 * Classe abstraite Action à réimplémenter pour chaque type d'action
 */
public abstract class Action {
    /**
     * Libelle de l'action (ex: "AAPL" pour Apple)
     */
    private String libelle; 
    /**
     * Nom de l'action (ex: "Apple")
     */
    private String nom;
    /**
     * Description de l'action (ex: "Action Apple Inc...")
     */
    private String description;

    /**
     * Constructeur de la classe Action
     * @param libelle
     * @param nom
     * @param description
     */
    protected Action(String libelle, String nom, String description) throws IllegalArgumentException {
        int longueurLibelleMin = 3;
        int longueurLibelleMax = 4;
        if (libelle == null || libelle.length() != longueurLibelleMin && libelle.length() != longueurLibelleMax) {
            throw new IllegalArgumentException("Le libellé doit contenir 3 à 4 caractères");
        }
        if (nom == null || nom.isEmpty()){
            throw new IllegalArgumentException("Le nom doit contenir au moins 1 caractère");
        }
        if (description == null || description.isEmpty()){
            throw new IllegalArgumentException("La description doit contenir au moins 1 caractère");
        }

        this.libelle = libelle;
        this.nom = nom;
        this.description = description;


    }

    /**
     * Constructeur VIDE de la classe Action
     */
    public Action() {
        this.libelle = "";
        this.nom = "";
        this.description = "";
    }
    /**
     * Getter de l'attribut libelle
     * @return String
     */
    public String getLibelle() {
        return libelle;
    }
    /**
     * Getter de l'attribut nom
     * @return String
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de l'attribut description
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Calcul de la valeur de l'action à une date donnée (à réimplémenter pour chaque type d'action)
     * @return double
     */
    public abstract double calculerValeurDate(Date date);

    /**
     * Affichage de l'action
     * @return String
     */
    public String toString() {
        return "Action [ " + libelle + " : nom=" + nom + ", description=" + description + "]";
    }

    /**
     * Redéfinition de la méthode equals pour comparer deux actions (test sur le libelle qui nous sert d'id)
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Action action = (Action) obj;
        return this.libelle.equals(action.getLibelle());
    }
    /**
     * Redéfinition de la méthode hashCode
     * @return int
     */
    @Override
    public int hashCode() {
        return this.libelle.hashCode();
    }

}
