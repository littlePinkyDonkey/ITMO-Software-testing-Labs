package andrei.teplyh.trigonometric;

public class TrigonometricFunction {
    private SecCalculator secCalculator;

    public TrigonometricFunction(Double accuracy) {
        this.secCalculator = new SecCalculator(accuracy);
    }

    public double calculateTrigFunction(Double x) throws IllegalArgumentException {
        if (x > 0.0) {
            throw new IllegalArgumentException("X должен быть меньше или равен нулю");
        }

        double secResult = secCalculator.calculateFunction(x);

        return secResult / secResult;
    }

    public double calculateStub(Double x, Double secCalculatorResult) throws IllegalArgumentException {
        if (x > 0.0) {
            throw new IllegalArgumentException("X должен быть меньше или равен нулю");
        }

        return secCalculatorResult / secCalculatorResult;
    }
}
