
package actions.metier;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ActionTest {

    @Test
	public void testLongueurLibelleIncorrect_ShouldFail() {
        final String libelleATester = "AA";
        
        assertThrows(
        IllegalArgumentException.class,() -> {
			 new ActionSimple(libelleATester, "Apple", "Action Apple Inc...");
        });

	}

    @Test
    public void testLongueurLibelleCorrect_ShouldPass() {
        final String libelleATesterLongueur3 = "APP";
        final String libelleATesterLongueur4 = "APPL";
        
        assertDoesNotThrow(() -> {
             new ActionSimple(libelleATesterLongueur3, "Apple", "Action Apple Inc...");
             new ActionSimple(libelleATesterLongueur4, "Apple", "Action Apple Inc...");

        });

	}


}
