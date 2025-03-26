
package actions.metier;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

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

    @Override
    public double calculerValeurDate(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        for (Cours coursDate : this.cours) {
            if (coursDate.getDate().equals(localDate)) {
                return coursDate.getValeur();
            }
        }
        throw new IllegalArgumentException("Aucun cours enregistré pour cette date.");
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
