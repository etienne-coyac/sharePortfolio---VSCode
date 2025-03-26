
package actions.metier;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ActionTest {

    // TESTS LIBELLE
    @Test
    void testLongueurLibelleIncorrect_ShouldFail() {
        final String libelleATester = "AA";

        assertThrows(
                IllegalArgumentException.class, () -> {
                    new ActionSimple(libelleATester, "Apple", "Action Apple Inc...");
                });
    }

    @Test
    void testLongueurLibelleIsNull_ShouldFail() {
        assertThrows(
                IllegalArgumentException.class, () -> {
                    new ActionSimple(null, "Apple", "Action Apple Inc...");
                });
    }

    @Test
    void testLongueurLibelleCorrectLongueur3_ShouldPass() {
        final String libelleATesterLongueur3 = "APP";

        assertDoesNotThrow(() -> {
            new ActionSimple(libelleATesterLongueur3, "Apple", "Action Apple Inc...");
        });

    }

    @Test
    void testLongueurLibelleCorrectLongueur4_ShouldPass() {
        final String libelleATesterLongueur4 = "APPL";
        assertDoesNotThrow(() -> {
            new ActionSimple(libelleATesterLongueur4, "Apple", "Action Apple Inc...");

        });
    }

    // TESTS DESCRIPTION

    @Test
    void testLongueurDescriptionIsNull_ShouldFail() {
        String descriptionNulle = null;
        assertThrows(
                IllegalArgumentException.class, () -> {
                    new ActionSimple("AAPL", "Apple", descriptionNulle);
                });
    }

    @Test
    void testLongueurDescriptionIsEmpty_ShouldFail() {
        String descriptionVide = "";
        assertThrows(
                IllegalArgumentException.class, () -> {
                    new ActionSimple("AAPL", "Apple", descriptionVide);
                });
    }

    @Test
    void testLongueurDescriptionIsCorrect_ShouldPass() {
        String descriptionCorrecte = "Action Apple Inc...";
        assertDoesNotThrow(() -> {
            new ActionSimple("AAPL", "Apple", descriptionCorrecte);
        });
    }

    // TESTS NOM
    @Test
    void testLongueurNomIsNull_ShouldFail() {
        String nomNul = null;
        assertThrows(
                IllegalArgumentException.class, () -> {
                    new ActionSimple("AAPL", nomNul, "Action Apple Inc...");
                });
    }

    @Test
    void testLongueurNomIsEmpty_ShouldFail() {
        String nomVide = "";
        assertThrows(
                IllegalArgumentException.class, () -> {
                    new ActionSimple("AAPL", nomVide, "Action Apple Inc...");
                });
    }

    @Test
    void testLongueurNomIsCorrect_ShouldPass() {
        String nomCorrect = "Apple";
        assertDoesNotThrow(() -> {
            new ActionSimple("AAPL", nomCorrect, "Action Apple Inc...");
        });
    }

    @Test
    void testToString_ShouldPass() {
        String description = "Action Apple Inc...";
        String libelle = "AAPL";
        String nom = "Apple";
        ActionSimple action = new ActionSimple(libelle, nom, description);
        String expected = "Action [ " + libelle + " : nom=" + nom + ", description=" + description + "]";

        assertEquals(expected, action.toString());
    }

    @Test
    void testToString_ShouldFail() {
        String description = "Action Apple Inc...";
        String libelle = "AAPL";
        String nom = "Apple";
        ActionSimple action = new ActionSimple(libelle, nom, description);
        String wrongDisplay = "Actiond [ " + libelle + " : nom=" + nom + ", description=" + description + "]";

        assertNotEquals(wrongDisplay, action.toString());
    }

    // Tests cours
    @Test
    void testEnregistrerCours() {
        ActionSimple a = new ActionSimple("lib", "nom", "desc");
        a.enregistrerCours(LocalDate.of(2025, 03, 26), 1);
        Assertions.assertEquals(1, a.getCours().size());
    }

    @Test
    void testCoursExisteDate() {
        ActionSimple a = new ActionSimple("lib", "nom", "desc");
        LocalDate date = LocalDate.of(2025, 03, 26);
        a.enregistrerCours(date, 2);
        assertThrows(IllegalArgumentException.class, () -> {
            a.enregistrerCours(date, 1);
        });
    }

    @Test
    void testCalculerValeurDate() {
        ActionSimple actionTest = new ActionSimple("lib", "nom", "desc");
        LocalDate date = LocalDate.of(2025, 03, 26);
        actionTest.enregistrerCours(date, 2);
        // TO DO
        //Assertions.assertEquals(2, actionTest.calculerValeurDate(date));
    }

}
