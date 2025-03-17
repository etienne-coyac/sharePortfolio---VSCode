
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
     * A reprendre plus tard
     * @return double
     */
    public double calculerValeurDate() {
        return 0;
    }
}
