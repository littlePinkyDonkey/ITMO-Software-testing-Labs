package andrei.teplyh.logarithmic;

import andrei.teplyh.AbstractFunction;

public class Log2 extends AbstractFunction {
    private Ln ln;

    {
        getStubsTable().put(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        getStubsTable().put(2.0 - 0.01, 0.992768);
        getStubsTable().put(2.0, 1.0);
        getStubsTable().put(2.0 + 0.01, 1.00720);

        getStubsTable().put(0.0 - 0.01, Double.NaN);
        getStubsTable().put(0.0, Double.NEGATIVE_INFINITY);
        getStubsTable().put(0.0 + 0.01, -6.632979274557514);

        getStubsTable().put(1.0 - 0.01, -0.0144996);
        getStubsTable().put(1.0, 0.0);
        getStubsTable().put(1.0 + 0.01, 0.0143553);
    }

    public Log2(Double accuracy) {
        super(accuracy);
        this.ln = new Ln(accuracy);
    }

    @Override
    public Double calculateFunction(Double x) {
        return ln.calculateFunction(x) / ln.calculateFunction(2.0);
    }

    public Double calculateStub(Double lnStub) {
        return lnStub / ln.getStubsTable().get(2.0);
    }
}
