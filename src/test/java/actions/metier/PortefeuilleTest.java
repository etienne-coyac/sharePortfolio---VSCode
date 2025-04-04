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
        Portefeuille.resetIdCompteur();
        Portefeuille port1 = new Portefeuille();
        Portefeuille port2 = new Portefeuille();
        assertEquals(1, port1.getIdentifiant());
        assertEquals(2, port2.getIdentifiant());
    }

    /**
     * Verifie si la methode de reset du compteur d'identifiants fonctionne correctement
     * Test validé si le résultat du assertEquals est "true"
     */
    @Test
    void testResetIdCompteur_SHOULDPASS(){
        Portefeuille.resetIdCompteur();
        Portefeuille port1 = new Portefeuille();
        assertEquals(1, port1.getIdentifiant());
        Portefeuille.resetIdCompteur();
        Portefeuille port2 = new Portefeuille();
        assertEquals(1, port1.getIdentifiant());
        assertEquals(1, port2.getIdentifiant());
    }

    /**
     * Test de l'ajout d'une action simple dans un portefeuille.
     * Test validé si le résultat du assertEquals est "true"
     */
    @Test
    void testAddAction() {
        Portefeuille port = new Portefeuille();
        ActionSimple act = new ActionSimple("FR2", "NomTest", "descriptionTest");

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
        ActionSimple act = new ActionSimple("FR2", "nomTest","descriptionTest");

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
        ActionSimple act = new ActionSimple("FR2", "nomTest", "descriptionTest");
        port.addAction(act);
        assertFalse(port.isEmpty());
    }

    @Test 
    void toStringTest(){
        Portefeuille.resetIdCompteur();
        Portefeuille port = new Portefeuille();
        assertEquals("Portefeuille [identifiant=1, listeActions=[]]", port.toString());
    }

    @Test
    void getListeActionTest() {
        Portefeuille port = new Portefeuille(); 
        assertEquals(new ArrayList<>() , port.getListeActions());
    }

    @Test
    void alimenterPortefeuilleTest() {
        int montant1 = 100;
        int montant2 = 50;

        Portefeuille port = new Portefeuille();
        port.alimenterPortefeuille(montant1);
        assertEquals(100, port.getSolde());
        port.alimenterPortefeuille(montant2);
        assertEquals(150, port.getSolde());

    }
    
}
