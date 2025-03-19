package actions.metier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class PortefeuilleTest {

    /**
     * Test de la génération automatique de l'identifiant du portefeuille.
     * Test validé si le résultat du assertEquals est "true"
     */
    @Test
    void testAutoIncrementId() {
        Portefeuille port1 = new Portefeuille();
        Portefeuille port2 = new Portefeuille();

        assertEquals(1, port1.getIdentifiant());
        assertEquals(2, port2.getIdentifiant());
    }

    /**
     * Test de l'ajout d'une action simple dans un portefeuille.
     * Test validé si le résultat du assertEquals est "true"
     */
    @Test
    void testAddAction() {
        Portefeuille port = new Portefeuille();
        ActionSimple act = new ActionSimple("France2", null, null);

        port.addAction(act);

        List<Action> actions = port.getListeActions();
        assertEquals(1, actions.size());
    }

    /**
     * Test d'une suppression d'une action simple dans un portefeuille.
     * Test validé si le résultat du assertEquals est "true"
     */
    @Test
    void testRemoveAction() {
        Portefeuille port = new Portefeuille();
        ActionSimple act = new ActionSimple("France2", null, null);

        port.addAction(act);

        List<Action> actions = port.getListeActions();
        assertEquals(1, actions.size());

        actions.remove(act);
        assertEquals(0, actions.size());
    }

    /**
     * Test d'un portefeuille, ayant une liste d'action vide
     * Test validé si le résulté du assertTrue est "true"
     */
    @Test
    void isEmptyTest(){
        Portefeuille port = new Portefeuille();
        assertTrue(port.isEmpty());
    }

    /**
     * Test d'un portefeuille, ayant une liste d'action
     * Test validé si le résulté du assertFalse est "true"
     */
    @Test
    void isNotEmptyTest(){
        Portefeuille port = new Portefeuille();
        ActionSimple act = new ActionSimple("France2", null, null);
        port.addAction(act);
        assertFalse(port.isEmpty());
    }

    @Test 
    void toStringTest(){
        Portefeuille port = new Portefeuille();
        assertEquals("Portefeuille [identifiant=1 , listeActions=[]]", port.toString());
    }

    @Test
    void getListeActionTest() {
        Portefeuille port = new Portefeuille(); 
        assertEquals(new ArrayList<>() , port.getListeActions());
    }
    
}
