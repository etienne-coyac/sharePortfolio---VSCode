
package actions.metier;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActionComposeeTest {
    

    private String libelle = "libC";
    private String nom = "nomC";
    private String description = "descriptionC";

    String libelleSimple1 = "lib1";
    String nomSimple1 = "nomSimple1";
    String descriptionSimple1= "descriptionSimple1";

    String libelleSimpl2 = "lib2";
    String nomSimple2 = "nomSimple2";
    String descriptionSimple2 = "descriptionSimple2";

    String libelleSimpl3 = "lib3";
    String nomSimple3 = "nomSimple3";
    String descriptionSimple3 = "descriptionSimple3";

    @Test
    public void ActionComposeeTest_creation_actionComposee_check_attributs() {
        ActionComposee actionComposee = new ActionComposee(libelle, nom, description);
        Assertions.assertEquals(libelle, actionComposee.getLibelle());
        Assertions.assertEquals(nom, actionComposee.getNom());
        Assertions.assertEquals(description, actionComposee.getDescription());
    }

    private ActionSimple actionSimple1 = new ActionSimple(libelleSimple1, nomSimple1, descriptionSimple1);
    private ActionSimple actionSimple2 = new ActionSimple(libelleSimpl2, nomSimple2, descriptionSimple2);
    private ActionSimple actionSimple3 = new ActionSimple(libelleSimpl3, nomSimple3, descriptionSimple3);
    private ActionComposee actionComposee = new ActionComposee(libelle, nom, description);

    @Test
    public void ActionComposeeTest_insertion_actionSimple_shouldPass() {
        //test Insertion
        actionComposee.addActionsimple(actionSimple1, 0.5);
        Assertions.assertEquals(1, actionComposee.ListActionSimple.get(actionSimple1));
        Assertions.assertTrue(actionComposee.ListActionSimple.containsKey(actionSimple1));

        actionComposee.addActionsimple(actionSimple2, 0.5);
        Assertions.assertEquals(0.5, actionComposee.ListActionSimple.get(actionSimple2));
        Assertions.assertEquals(0.5, actionComposee.ListActionSimple.get(actionSimple1));
        Assertions.assertTrue(actionComposee.ListActionSimple.containsKey(actionSimple2));
    }

    //test false insertion : pourcentage > 1
    @Test
    public void ActionComposeeTest_poucentage_incorrect_shouldFaile() {
        actionComposee.addActionsimple(actionSimple1, 0.6);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            actionComposee.addActionsimple(actionSimple2, 1.1);
        });
    }

    //test suppression
    @Test
    public void ActionComposeeTest_suppression_actionsimple_check_pourcentage_shouldPass() {
        actionComposee.addActionsimple(actionSimple1, 0.5);
        actionComposee.addActionsimple(actionSimple2, 0.5);
        actionComposee.removeActionsimple(actionSimple1);
        Assertions.assertFalse(actionComposee.ListActionSimple.containsKey(actionSimple1));
        Assertions.assertEquals(1.0, actionComposee.ListActionSimple.get(actionSimple2));
    }

    // //test update pourcentage
    // @Test
    // public void ActionComposeeTest_modification_pourcentage_actionSimple_check_pourcentage_shouldPass() {
    //     actionComposee.addActionsimple(actionSimple1, 0.5d);
    //     actionComposee.addActionsimple(actionSimple2, 0.5d);
    //     actionComposee.addActionsimple(actionSimple3, 0.5d);
    //     actionComposee.updatePourcentage(actionSimple3, 0.8d);
    //     Assertions.assertEquals(0.8d, actionComposee.ListActionSimple.get(actionSimple3));
    //     Assertions.assertEquals(0.1d, actionComposee.ListActionSimple.get(actionSimple1));
        

    // }
}
