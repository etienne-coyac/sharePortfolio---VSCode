package actions.metier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Catalogue {
    private List<Action> actions;

    public Catalogue() {
        this.actions = new ArrayList<>();
    }

    public void addAction(Action a) {
        this.actions.add(a);
    }

    public Collection<Action> getActions() {
        return this.actions;
    }

    public void deleteActionByName(String name) {
        boolean deleted = this.actions.removeIf(a -> a.getNom().equals(name));
        if (!deleted) {
            throw new NoSuchElementException("L'action " + name + " n'existe pas.");
        }
    }

    public Action getActionByName(String name) throws NoSuchElementException {
        Optional<Action> action = this.actions.stream().filter(a -> name.equals(a.getNom())).findFirst();
        if (action.isPresent()) {
            return action.get();
        }
        throw new NoSuchElementException("L'action " + name + " n'existe pas.");
    }
}
