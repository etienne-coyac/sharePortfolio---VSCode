
package actions.metier;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActionComposeeTest {
    

    private String libelle;
    private String nom;
    private String description;

    String libelleSimple1 = "libelleSimple1";
    String nomSimple1 = "nomSimple1";
    String descriptionSimple1= "descriptionSimple1";

    String libelleSimpl2 = "libelleSimple2";
    String nomSimple2 = "nomSimple2";
    String descriptionSimple2 = "descriptionSimple2";

    private ActionSimple actionSimple1 = new ActionSimple(libelleSimple1, nomSimple1, descriptionSimple1);
    private ActionSimple actionSimple2 = new ActionSimple(libelleSimpl2, nomSimple2, descriptionSimple2);
    private ActionComposee actionComposee = new ActionComposee(libelle, nom, description);

    @Test
    public void ActionComposeeTest() {
        actionComposee.addActionsimple(actionSimple1, new BigDecimal("0.6"));
        Assertions.assertEquals(new BigDecimal("0.6"), actionComposee.ListActionSimple.get(actionSimple1));
        Assertions.assertTrue(actionComposee.ListActionSimple.containsKey(actionSimple1));

        actionComposee.addActionsimple(actionSimple2, new BigDecimal("0.4"));
        Assertions.assertEquals(new BigDecimal("0.4"), actionComposee.ListActionSimple.get(actionSimple2));
        Assertions.assertTrue(actionComposee.ListActionSimple.containsKey(actionSimple2));
    }

    @Test
    public void ActionComposeeTest2() {
        actionComposee.addActionsimple(actionSimple1, new BigDecimal("0.6"));
        actionComposee.addActionsimple(actionSimple2, new BigDecimal("0.4"));
        actionComposee.removeActionsimple(actionSimple1);
        Assertions.assertFalse(actionComposee.ListActionSimple.containsKey(actionSimple1));
    }

    @Test
    public void ActionComposeeTest3() {
        actionComposee.addActionsimple(actionSimple1, new BigDecimal("0.6"));
        actionComposee.addActionsimple(actionSimple2, new BigDecimal("0.4"));
        actionComposee.updatePourcentage(actionSimple1, new BigDecimal("0.5"));
        Assertions.assertEquals(new BigDecimal("0.5"), actionComposee.ListActionSimple.get(actionSimple1));
    }
}
