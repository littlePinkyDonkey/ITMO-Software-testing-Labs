package andrei.teplyh.trigonometric;

import andrei.teplyh.AbstractFunction;

import static java.lang.Math.PI;

public class SecCalculator extends AbstractFunction {
    private CosCalculator cosCalculator;

    {
        getStubsTable().put(-PI, -1.0);
        getStubsTable().put(-PI / 2, Double.POSITIVE_INFINITY);
        getStubsTable().put(0.0, 1.0);
        getStubsTable().put(PI / 2, Double.POSITIVE_INFINITY);
        getStubsTable().put(PI, -1.0);
        getStubsTable().put(3 * PI / 4, -1.41421356375);
        getStubsTable().put(-3 * PI / 4, -1.41421356375);
        getStubsTable().put( PI / 4, 1.41421356375);
        getStubsTable().put(-PI / 4, 1.41421356375);
    }

    public SecCalculator(Double accuracy) {
        super(accuracy);
        this.cosCalculator = new CosCalculator(accuracy);
    }

    public Double calculateFunction(Double x) {
        double sum = cosCalculator.calculateFunction(x);
        final double INF = Double.POSITIVE_INFINITY;

        return Math.abs(1/sum) > INF ? INF : 1/sum;
    }

    public Double calculateStub(Double cosCalculatorResult) {
        final double INF = Double.POSITIVE_INFINITY;

        return Math.abs(1/cosCalculatorResult) > INF ? INF : 1/cosCalculatorResult;
    }
}
