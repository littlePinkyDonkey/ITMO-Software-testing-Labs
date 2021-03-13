package andrei.teplyh.logarithmic;

import andrei.teplyh.AbstractFunction;

import static java.lang.Double.*;

public class Ln extends AbstractFunction {

    {
        getStubsTable().put(POSITIVE_INFINITY, POSITIVE_INFINITY);
        getStubsTable().put(Math.E - 0.01, 0.996314422);
        getStubsTable().put(Math.E, 1.0);
        getStubsTable().put(Math.E + 0.01, 1.003672044);
        getStubsTable().put(0.0 - 0.01, NaN);
        getStubsTable().put(0.0, Double.NEGATIVE_INFINITY);
        getStubsTable().put(0.0 + 0.01, -4.597299250490899);
        getStubsTable().put(1.0 - 0.01, -0.010050000000000009);
        getStubsTable().put(1.0, 0.0);
        getStubsTable().put(1.0 + 0.01, 0.00995000000000001);
        getStubsTable().put(2.0, 0.693147180559);
        getStubsTable().put(3.0, 1.098612288);
        getStubsTable().put(5.0, 1.60943791243);
        getStubsTable().put(10.0, 2.302585092994);
    }

    public Ln(double precision) {
        super(precision);
    }

    @Override
    public Double calculateFunction(Double x) {
        if (isNaN(x) || x < 0.0) {
            return NaN;
        }

        if (x == POSITIVE_INFINITY) {
            return POSITIVE_INFINITY;
        }

        if (x == 0.0) {
            return NEGATIVE_INFINITY;
        }

        double value = 0;
        double prevValue;
        int n = 1;
        int k = 1;
        if (Math.abs(x - 1) <= 1) {
            do {
                prevValue = value;
                value -= ((Math.pow(-1, n) * Math.pow(x - 1, n)) / n);
                n++;
            } while (getAccuracy() <= Math.abs(value - prevValue));
        } else {
            do {
                prevValue = value;
                value -= ((Math.pow(-1, k) * Math.pow(x - 1, -k)) / k);
                k++;
            } while (getAccuracy() <= Math.abs(value - prevValue));
            value += this.calculateFunction(x - 1);
        }

        return value;
    }
}
