import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    @Test
    void calculate() {
        BodyMassIndex bmi1 = new BodyMassIndex(65.0, 140.0);
        assertEquals(23.3, BodyMassIndex.calculate(bmi1));
    }

    @Test
    void category() {
        BodyMassIndex bmi2 = new BodyMassIndex(71.0, 170.0);
        assertEquals("Normal weight", BodyMassIndex.category(bmi2));
    }
}