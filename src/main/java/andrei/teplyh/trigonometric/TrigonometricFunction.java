package andrei.teplyh.trigonometric;

import andrei.teplyh.AbstractFunction;

public class TrigonometricFunction extends AbstractFunction {
    private SecCalculator secCalculator;

    public TrigonometricFunction(Double accuracy) {
        super(accuracy);
        this.secCalculator = new SecCalculator(accuracy);
    }

    public Double calculateFunction(Double x) throws IllegalArgumentException {
        if (x > 0.0) {
            throw new IllegalArgumentException("X должен быть меньше или равен нулю");
        }

        double secResult = secCalculator.calculateFunction(x);

        return secResult / secResult;
    }

    public double calculateTrigFunctionStub(Double x, Double secCalculatorResult) throws IllegalArgumentException {
        if (x > 0.0) {
            throw new IllegalArgumentException("X должен быть меньше или равен нулю");
        }

        return secCalculatorResult / secCalculatorResult;
    }
}
