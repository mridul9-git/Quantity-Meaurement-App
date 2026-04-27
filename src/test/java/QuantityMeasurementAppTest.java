import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testFeetToInchEquality() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }
    @Test
    void testSameUnitEquality() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(1.0, LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testDifferentValues() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(2.0, LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    @Test
    void testInchToInch() {
        Quantity q1 = new Quantity(12.0, LengthUnit.INCH);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }
    @Test
    void testYardToFeet() {
        Quantity q1 = new Quantity(1.0, LengthUnit.YARD);
        Quantity q2 = new Quantity(3.0, LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testYardToInch() {
        Quantity q1 = new Quantity(1.0, LengthUnit.YARD);
        Quantity q2 = new Quantity(36.0, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testCmToInch() {
        Quantity q1 = new Quantity(1.0, LengthUnit.CM);
        Quantity q2 = new Quantity(0.393701, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testDifferentUnitsNotEqual() {
        Quantity q1 = new Quantity(1.0, LengthUnit.CM);
        Quantity q2 = new Quantity(1.0, LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }
}