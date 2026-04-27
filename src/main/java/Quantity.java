public class Quantity {

    private final double value;
    private final LengthUnit unit;

    public Quantity(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Quantity other = (Quantity) obj;

        double thisInFeet = this.unit.toFeet(this.value);
        double otherInFeet = other.unit.toFeet(other.value);

        return Double.compare(thisInFeet, otherInFeet) == 0;
    }
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (source == null || target == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        // convert to base (feet)
        double valueInFeet = source.toFeet(value);

        // convert from feet to target
        return valueInFeet / target.toFeet(1.0);
    }public static Quantity add(Quantity q1, Quantity q2) {

        if (q1 == null || q2 == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }

        // convert both to base unit (feet)
        double q1InFeet = q1.unit.toFeet(q1.value);
        double q2InFeet = q2.unit.toFeet(q2.value);

        // add
        double sumInFeet = q1InFeet + q2InFeet;

        // convert back to unit of first operand
        double resultValue = sumInFeet / q1.unit.toFeet(1.0);

        return new Quantity(resultValue, q1.unit);
    }
}