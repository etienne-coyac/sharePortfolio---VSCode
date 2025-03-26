package actions.metier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


/**
 * Catalogue général d'actions disponibles dans l'application
 */
public class Catalogue {
    /**
     * Liste des actions
     */
    private List<Action> actions;

    public Catalogue() {
        this.actions = new ArrayList<>();
    }

    /**
     * ajouter une action au catalogue
     * 
     * @param a action
     */
    public void addAction(Action a) throws IllegalArgumentException {
        if (this.actions.contains(a)) {
            throw new IllegalArgumentException(
                    String.format("L'action %s est déjà listée dans le catalogue.", a.getNom()));
        }
        this.actions.add(a);
    }

    /**
     * Get la liste d'actions (non modifiables pour préserver l'encapsulation)
     * 
     * @return la liste d'actions
     */
    public Collection<Action> getActions() {
        return Collections.unmodifiableCollection(this.actions);
    }

    /**
     * Supprimer une action par nom
     * 
     * @param name nom de l'action
     * @throws NoSuchElementException
     */
    public void deleteActionByName(String name) throws NoSuchElementException {
        boolean deleted = this.actions.removeIf(a -> a.getNom().equals(name));
        if (!deleted) {
            throw new NoSuchElementException(String.format("L'action %s n'existe pas.", name));
        }
    }

    /**
     * Get une action par nom
     * 
     * @param name nom de l'action
     * @return l'action trouvée
     * @throws NoSuchElementException
     */
    public Action getActionByName(String name) throws NoSuchElementException {
        Optional<Action> action = this.actions.stream().filter(a -> name.equals(a.getNom())).findFirst();
        if (action.isPresent()) {
            return action.get();
        }
        throw new NoSuchElementException(String.format("L'action %s n'existe pas.", name));
    }

    /**
     * Afficher le catalogue des actions (pour l'instant affichage sous forme de log)
     */
    public String afficherLeCatalogueDesActions() {
        StringBuilder builder = new StringBuilder();
        String enTete = "---------- Liste des actions disponibles : ----------\n";
        builder.append(enTete);
        for (Action a : this.actions) {
            builder.append(a.toString()).append("\n");
        }
       
        return builder.toString();
    }
}
