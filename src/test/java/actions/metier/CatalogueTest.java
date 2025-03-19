package actions.metier;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatalogueTest {
    public class ActionImpl extends Action {

        public ActionImpl(String libelle, String nom, String desc) {
            super(libelle, nom, desc);
        }

        @Override
        public double calculerValeurDate() {
            return 0;
        }
    }

    private Catalogue catalogue;
    private final String testActionName = "testNom";
    private final Action action = new ActionImpl("testLibelle", testActionName, "testDesc");

    @BeforeEach
    void createCatalogue() {
        this.catalogue = new Catalogue();
        catalogue.addAction(action);
    }

    @Test
    void testAddAction() {
        Assertions.assertEquals(1, catalogue.getActions().size());
    }

    @Test
    void testActionAlreadyExists() {
        Action actionDuplicate = new ActionImpl("testLibelle", testActionName, "testDesc")
        assertThrows(IllegalArgumentException.class, () -> {
            catalogue.addAction(actionDuplicate);
        });
    }

    @Test
    void testGetActionByName() {
        Action actionFound = catalogue.getActionByName(testActionName);
        assertNotNull(actionFound);
    }

    @Test
    void testGetActionByNameThrows() {
        assertThrows(NoSuchElementException.class, () -> {
            catalogue.getActionByName("wrongName");
        });
    }

    @Test
    void testDeleteAction() {
        catalogue.deleteActionByName(testActionName);
        Assertions.assertEquals(0, catalogue.getActions().size());
    }

}
