
package actions.metier;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Cours {
    private LocalDate date;
    private double valeur;

    Cours(LocalDate date, double valeur) throws IllegalArgumentException {
        if (valeur <= 0) {
            throw new IllegalArgumentException("Le cours doit être supérieur à 0.");
        }
        this.date = date;
        this.valeur = valeur;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public double getValeur() {
        return this.valeur;
    }

    @Override
    public String toString() {
        return "Cours [date=" + new SimpleDateFormat("dd/MM/yyyy").format(date) + ", valeur=" + valeur + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
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
        Cours other = (Cours) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        return true;
    }

}
