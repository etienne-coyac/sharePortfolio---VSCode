package actions.metier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class PortefeuilleTest {

    /**
     * Test de la génération automatique de l'identifiant du portefeuille.
     * Test validé si le résultat du assertEquals est "true"
     */
    @Test
    public void testAutoIncrementId() {
        Portefeuille port1 = new Portefeuille();
        Portefeuille port2 = new Portefeuille();

        assertEquals(1, port1.getIdentifiant());
        assertEquals(2, port2.getIdentifiant());
    }

    @Test
    public void testAddAction() {
        Portefeuille port = new Portefeuille();
        ActionSimple act = new ActionSimple(null, null, null);

        port.addAction(act);

        List<Action> actions = port.getListeActions();
        assertEquals(1, actions.size());
    }
    
}
