import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testEquality_DifferentValue() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(2.0);

        assertFalse(f1.equals(f2));
    }

    @Test
    void testEquality_NullComparison() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);

        assertFalse(f1.equals(null));
    }

    @Test
    void testEquality_SameReference() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(f1.equals(f1));
    }
    @Test
    void testInchEquality_SameValue() {
        QuantityMeasurementApp.Inch i1 = new QuantityMeasurementApp.Inch(1.0);
        QuantityMeasurementApp.Inch i2 = new QuantityMeasurementApp.Inch(1.0);

        assertTrue(i1.equals(i2));
    }

    @Test
    void testInchEquality_DifferentValue() {
        QuantityMeasurementApp.Inch i1 = new QuantityMeasurementApp.Inch(1.0);
        QuantityMeasurementApp.Inch i2 = new QuantityMeasurementApp.Inch(2.0);

        assertFalse(i1.equals(i2));
    }

    @Test
    void testInchEquality_NullComparison() {
        QuantityMeasurementApp.Inch i1 = new QuantityMeasurementApp.Inch(1.0);

        assertFalse(i1.equals(null));
    }

    @Test
    void testInchEquality_SameReference() {
        QuantityMeasurementApp.Inch i1 = new QuantityMeasurementApp.Inch(1.0);

        assertTrue(i1.equals(i1));
    }
}
