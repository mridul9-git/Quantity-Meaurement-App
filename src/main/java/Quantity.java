public class Quantity {

    private final double value;
    private final LengthUnit unit;

    public Quantity(double value, LengthUnit unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Quantity other = (Quantity) obj;

        double thisInFeet = this.unit.convertToBaseUnit(this.value);
        double otherInFeet = other.unit.convertToBaseUnit(other.value);

        return Double.compare(thisInFeet, otherInFeet) == 0;
    }


    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (source == null || target == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        double base = source.convertToBaseUnit(value);

        return target.convertFromBaseUnit(base);
    }


    public static Quantity add(Quantity q1, Quantity q2) {

        if (q1 == null || q2 == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }

        double sumFeet =
                q1.unit.convertToBaseUnit(q1.value)
                        + q2.unit.convertToBaseUnit(q2.value);

        double resultValue = q1.unit.convertFromBaseUnit(sumFeet);

        return new Quantity(resultValue, q1.unit);
    }

    // ================= ADD WITH TARGET (UC7) =================
    public static Quantity add(Quantity q1, Quantity q2, LengthUnit targetUnit) {

        if (q1 == null || q2 == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double sumFeet =
                q1.unit.convertToBaseUnit(q1.value)
                        + q2.unit.convertToBaseUnit(q2.value);

        double resultValue = targetUnit.convertFromBaseUnit(sumFeet);

        return new Quantity(resultValue, targetUnit);
    }
}