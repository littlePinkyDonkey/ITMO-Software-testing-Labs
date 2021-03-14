package andrei.teplyh.logarithmic;

import andrei.teplyh.AbstractFunction;

import static java.lang.Double.*;

public class Log3 extends AbstractFunction {
    private Ln ln;

    {
        getStubsTable().put(POSITIVE_INFINITY, POSITIVE_INFINITY);
        getStubsTable().put(3.0 - 0.01, 0.996961);
        getStubsTable().put(3.0, 1.0);
        getStubsTable().put(3.0 + 0.01, 1.00303);

        getStubsTable().put(0.0 - 0.01, NaN);
        getStubsTable().put(0.0, NEGATIVE_INFINITY);
        getStubsTable().put(0.0 + 0.01, -4.191807);

        getStubsTable().put(1.0 - 0.01, -0.00914821);
        getStubsTable().put(1.0, 0.0);
        getStubsTable().put(1.0 + 0.01, 0.00905718);
    }

    public Log3(Double accuracy) {
        super(accuracy);
        this.ln = new Ln(accuracy);
    }

    @Override
    public Double calculateFunction(Double x) {
        return ln.calculateFunction(x) / ln.calculateFunction(3.0);
    }

    public Double calculateStub(Double lnStub) {
        return lnStub / ln.getStubsTable().get(3.0);
    }
}
