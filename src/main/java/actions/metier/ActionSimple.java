
package actions.metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe ActionSimple héritant de la classe abstraite Action
 */
public class ActionSimple extends Action {

    private List<Cours> cours;

    /**
     * Constructeur de la classe ActionSimple
     * 
     * @param libelle
     * @param nom
     * @param description
     */
    public ActionSimple(String libelle, String nom, String description) {
        super(libelle, nom, description);
        this.cours = new ArrayList<>();
    }

    public void enregistrerCours(LocalDate date, double valeur) throws IllegalArgumentException {
        Cours newCours = new Cours(date, valeur);
        if (this.cours.contains(newCours)) {
            throw new IllegalArgumentException("Le cours est déjà enregistré pour cette date.");
        }

        this.cours.add(newCours);
    }

    public List<Cours> getCours() {
        return Collections.unmodifiableList(this.cours);
    }

    /**
     * A reprendre plus tard
     * 
     * @return double
     */
    public double calculerValeurDate() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
