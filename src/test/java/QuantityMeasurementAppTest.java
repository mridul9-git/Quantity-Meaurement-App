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
    void testYardToInch() {
        Quantity q1 = new Quantity(1.0, LengthUnit.YARD);
        Quantity q2 = new Quantity(36.0, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }



    @Test
    void testDifferentUnitsNotEqual() {
        Quantity q1 = new Quantity(1.0, LengthUnit.CM);
        Quantity q2 = new Quantity(1.0, LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }
    @Test
    void testFeetToInches() {
        assertEquals(12.0,
                Quantity.convert(1.0, LengthUnit.FEET, LengthUnit.INCH));
    }

    @Test
    void testInchesToFeet() {
        assertEquals(2.0,
                Quantity.convert(24.0, LengthUnit.INCH, LengthUnit.FEET));
    }

    @Test
    void testYardToFeet() {
        assertEquals(3.0,
                Quantity.convert(1.0, LengthUnit.YARD, LengthUnit.FEET));
    }

    @Test
    void testCmToInch() {
        assertEquals(0.393701,
                Quantity.convert(1.0, LengthUnit.CM, LengthUnit.INCH),
                1e-6);
    }

    @Test
    void testZero() {
        assertEquals(0.0,
                Quantity.convert(0.0, LengthUnit.FEET, LengthUnit.INCH));
    }
    @Test
    void testFeetPlusFeet() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(2.0, LengthUnit.FEET);

        assertEquals(new Quantity(3.0, LengthUnit.FEET),
                Quantity.add(q1, q2));
    }

    @Test
    void testFeetPlusInch() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        assertEquals(new Quantity(2.0, LengthUnit.FEET),
                Quantity.add(q1, q2));
    }

    @Test
    void testInchPlusFeet() {
        Quantity q1 = new Quantity(12.0, LengthUnit.INCH);
        Quantity q2 = new Quantity(1.0, LengthUnit.FEET);

        assertEquals(new Quantity(24.0, LengthUnit.INCH),
                Quantity.add(q1, q2));
    }

    @Test
    void testWithZero() {
        Quantity q1 = new Quantity(5.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(0.0, LengthUnit.INCH);

        assertEquals(new Quantity(5.0, LengthUnit.FEET),
                Quantity.add(q1, q2));
    }
    @Test
    void testAddition_TargetFeet() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        assertEquals(new Quantity(2.0, LengthUnit.FEET),
                Quantity.add(q1, q2, LengthUnit.FEET));
    }

    @Test
    void testAddition_TargetInch() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        assertEquals(new Quantity(24.0, LengthUnit.INCH),
                Quantity.add(q1, q2, LengthUnit.INCH));
    }

    @Test
    void testAddition_TargetYard() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        Quantity result = Quantity.add(q1, q2, LengthUnit.YARD);

        assertEquals(0.666666, result.getValue(), 1e-3);
    }
    @Test
    void testAddition_TargetCM() {
        Quantity q1 = new Quantity(2.54, LengthUnit.CM);
        Quantity q2 = new Quantity(1.0, LengthUnit.INCH);

        Quantity result = Quantity.add(q1, q2, LengthUnit.CM);

        assertEquals(5.08, result.getValue(), 1e-2);
    }
    @Test
    void testKgToGramEquality() {
        assertTrue(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .equals(new QuantityWeight(1000.0, WeightUnit.GRAM))
        );
    }

    @Test
    void testKgToPoundEquality() {
        assertTrue(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .equals(new QuantityWeight(2.20462, WeightUnit.POUND))
        );
    }

    @Test
    void testConversion() {
        QuantityWeight q = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertEquals(1000.0,
                q.convertTo(WeightUnit.GRAM).getValue());
    }

    @Test
    void testAddition() {
        QuantityWeight q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        assertEquals(2.0,
                QuantityWeight.add(q1, q2).getValue());
    }

}