package actions.metier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class CoursTest {

    @Test
    void testNewCours() {
        LocalDate date = LocalDate.of(2025, 3, 26);
        double value = 1;
        Cours c = new Cours(date, value);
        assertEquals(c.getDate(), date);
        assertEquals(c.getValeur(), value);
    }

    @Test
    void testCoursNegatif() {
        LocalDate date = LocalDate.of(2025, 03, 26);
        assertThrows(IllegalArgumentException.class, () -> {
            new Cours(date, -1);
        });
    }
}
