
package actions.metier;

import java.sql.Date;

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


    @Override
    public double calculerValeurDate(java.util.Date date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculerValeurDate'");
    }
}
