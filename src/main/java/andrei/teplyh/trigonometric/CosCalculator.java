package andrei.teplyh.trigonometric;

import andrei.teplyh.AbstractFunction;
import andrei.teplyh.util.FactorialSeries;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Double.*;
import static java.lang.Math.PI;

public class CosCalculator extends AbstractFunction {

    {
        getStubsTable().put(-PI, -1.0);
        getStubsTable().put(-PI / 2, 0.0);
        getStubsTable().put(0.0, 1.0);
        getStubsTable().put(PI / 2, 0.0);
        getStubsTable().put(PI, -1.0);
        getStubsTable().put(3 * PI / 4, -0.707106781);
        getStubsTable().put(-3 * PI / 4, -0.707106781);
        getStubsTable().put( PI / 4, 0.707106781);
        getStubsTable().put(-PI / 4, 0.707106781);
    }

    public CosCalculator(Double accuracy) {
        super(accuracy);
    }

    public Double calculateFunction(Double arg) {
        if (isNaN(arg) || isInfinite(arg)) {
            return NaN;
        }

        arg = subOverages(arg);

        int scale = 10;

        BigDecimal last;
        BigDecimal value = new BigDecimal(0d, MathContext.UNLIMITED);
        int n = 0;

        do {
            last = value;
            value = value.add((new BigDecimal(-1, MathContext.UNLIMITED).pow(n)).
                    multiply((new BigDecimal(arg, MathContext.UNLIMITED).pow(2 * n))).
                    divide(new BigDecimal(FactorialSeries.factorial(2 * n)), scale, RoundingMode.HALF_UP));
            n++;
        } while (getAccuracy() <= value.subtract(last).abs().doubleValue());

        double valueToDouble = value.setScale(scale, RoundingMode.UP).doubleValue();

        if(valueToDouble > 1) valueToDouble = 1;
        else if(valueToDouble < -1) valueToDouble = -1;
        return valueToDouble;
    }

    protected static double subOverages(double arg) {
        long periodCounter = (long) (arg / (2 * PI)) + ((arg > 0)? 1: -1);

        if(arg > PI || arg < -PI)
            arg -= periodCounter * 2 * PI;
        return arg;
    }
}
