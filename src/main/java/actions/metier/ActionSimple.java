
package actions.metier;
/**
 * Classe ActionSimple héritant de la classe abstraite Action
 */
public class ActionSimple extends Action {
    /**
     * Constructeur de la classe ActionSimple
     * @param libelle
     * @param nom
     * @param description
     */
    public ActionSimple(String libelle, String nom, String description) {
        super(libelle, nom, description);
    }

    /**
     * 
     * @return double
     */
    public double getValeur() {
        return 0;
    }
}
