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
}