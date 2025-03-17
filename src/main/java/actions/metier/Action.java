package actions.metier;
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
    public Action(String libelle, String nom, String description) throws IllegalArgumentException {
        if (libelle == null || libelle.length() != 3 && libelle.length() != 4) {
            throw new IllegalArgumentException("Le libellé doit contenir 3 à 4 caractères");
        }
        if (nom == null || nom.length() <1){
            throw new IllegalArgumentException("Le nom doit contenir au moins 1 caractère");
        }
        if (description == null || description.length() <1){
            throw new IllegalArgumentException("La description doit contenir au moins 1 caractère");
        }

        this.libelle = libelle;
        this.nom = nom;
        this.description = description;


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
    public abstract double calculerValeurDate();
}
