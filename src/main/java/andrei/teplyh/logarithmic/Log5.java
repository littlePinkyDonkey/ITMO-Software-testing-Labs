package andrei.teplyh.logarithmic;

import andrei.teplyh.AbstractFunction;

import static java.lang.Double.*;

public class Log5 extends AbstractFunction {
    private Ln ln;

    {
        getStubsTable().put(POSITIVE_INFINITY, POSITIVE_INFINITY);
        getStubsTable().put(5.0 - 0.01, 0.998756);
        getStubsTable().put(5.0, 1.0);
        getStubsTable().put(5.0 + 0.01, 1.00124);

        getStubsTable().put(0.0 - 0.01, NaN);
        getStubsTable().put(0.0, NEGATIVE_INFINITY);
        getStubsTable().put(0.0 + 0.01, -2.861353);

        getStubsTable().put(1.0 - 0.01, -0.00624462);
        getStubsTable().put(1.0, 0.0);
        getStubsTable().put(1.0 + 0.01, 0.00618249);
    }

    public Log5(Double accuracy) {
        super(accuracy);
        this.ln = new Ln(accuracy);
    }

    @Override
    public Double calculateFunction(Double x) {
        return ln.calculateFunction(x) / ln.calculateFunction(5.0);
    }

    public Double calculateStub(Double lnStub) {
        return lnStub / ln.getStubsTable().get(5.0);
    }
}
