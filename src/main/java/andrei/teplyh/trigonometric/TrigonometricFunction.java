package andrei.teplyh.trigonometric;

public class TrigonometricFunction {
    private SecCalculator secCalculator;

    public TrigonometricFunction(SecCalculator secCalculator) {
        this.secCalculator = secCalculator;
    }

    public double calculateTrigFunction(Double x) {
        if (x > 0.0) {
            throw new IllegalArgumentException("X должен быть меньше или равен нулю");
        }

        double secResult = secCalculator.calculateFunction(x);

        return secResult / secResult;
    }
}
