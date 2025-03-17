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
    public void addAction(Action a) {
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
            throw new NoSuchElementException("L'action " + name + " n'existe pas.");
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
        throw new NoSuchElementException("L'action " + name + " n'existe pas.");
    }
}
