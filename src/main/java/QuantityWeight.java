public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {

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

    public WeightUnit getUnit() {
        return unit;
    }

    // ================= EQUALITY =================
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityWeight other = (QuantityWeight) obj;

        double thisKg = this.unit.convertToBaseUnit(this.value);
        double otherKg = other.unit.convertToBaseUnit(other.value);

        return Math.abs(thisKg - otherKg) < 1e-5; // 🔥 slightly relaxed tolerance
    }
    // ================= CONVERT =================
    public QuantityWeight convertTo(WeightUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double base = unit.convertToBaseUnit(value);
        double result = targetUnit.convertFromBaseUnit(base);

        return new QuantityWeight(result, targetUnit);
    }

    // ================= ADD (UC6 STYLE) =================
    public static QuantityWeight add(QuantityWeight q1, QuantityWeight q2) {

        if (q1 == null || q2 == null) {
            throw new IllegalArgumentException("Null input");
        }

        double sumKg =
                q1.unit.convertToBaseUnit(q1.value)
                        + q2.unit.convertToBaseUnit(q2.value);

        double result = q1.unit.convertFromBaseUnit(sumKg);

        return new QuantityWeight(result, q1.unit);
    }

    // ================= ADD (UC7 STYLE) =================
    public static QuantityWeight add(QuantityWeight q1, QuantityWeight q2, WeightUnit targetUnit) {

        if (q1 == null || q2 == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double sumKg =
                q1.unit.convertToBaseUnit(q1.value)
                        + q2.unit.convertToBaseUnit(q2.value);

        double result = targetUnit.convertFromBaseUnit(sumKg);

        return new QuantityWeight(result, targetUnit);
    }
}