
package actions.metier;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ActionTest {

    // TESTS LIBELLE 
    @Test
	void testLongueurLibelleIncorrect_ShouldFail() {
        final String libelleATester = "AA";
        
        assertThrows(
        IllegalArgumentException.class,() -> {
			 new ActionSimple(libelleATester, "Apple", "Action Apple Inc...");
        });
	}
    
    @Test
	void testLongueurLibelleIsNull_ShouldFail() {
        assertThrows(
        IllegalArgumentException.class,() -> {
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
        IllegalArgumentException.class,() -> {
             new ActionSimple("AAPL", "Apple", descriptionNulle);
        }); 
    }

    @Test
    void testLongueurDescriptionIsEmpty_ShouldFail() {
        String descriptionVide = "";
        assertThrows(
        IllegalArgumentException.class,() -> {
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
    void testLongueurNomIsNull_ShouldFail() {
        String nomNul = null;
        assertThrows(
        IllegalArgumentException.class,() -> {
             new ActionSimple("AAPL", nomNul, "Action Apple Inc...");
        }); 
    }

    public void testLongueurNomIsEmpty_ShouldFail() {
        String nomVide = "";
        assertThrows(
        IllegalArgumentException.class,() -> {
             new ActionSimple("AAPL", nomVide, "Action Apple Inc...");
        }); 
    }

    public void testLongueurNomIsCorrect_ShouldPass() {
        String nomCorrect = "Apple";
        assertDoesNotThrow(() -> {
             new ActionSimple("AAPL", nomCorrect, "Action Apple Inc...");
        }); 
    }


    



}
