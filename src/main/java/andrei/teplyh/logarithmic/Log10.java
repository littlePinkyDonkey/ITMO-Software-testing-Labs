package andrei.teplyh.logarithmic;

import andrei.teplyh.AbstractFunction;

import static java.lang.Double.*;

public class Log10 extends AbstractFunction {
    private Ln ln;

    {
        getStubsTable().put(POSITIVE_INFINITY, POSITIVE_INFINITY);
        getStubsTable().put(10.0 - 0.01, 0.999565);
        getStubsTable().put(10.0, 1.0);
        getStubsTable().put(10.0 + 0.01, 1.00043);

        getStubsTable().put(0.0 - 0.01, NaN);
        getStubsTable().put(0.0, NEGATIVE_INFINITY);
        getStubsTable().put(0.0 + 0.01, -1.9966406951372424);

        getStubsTable().put(1.0 - 0.01, -0.00436481);
        getStubsTable().put(1.0, 0.0);
        getStubsTable().put(1.0 + 0.01, 0.00432137);
    }

    public Log10(Double accuracy) {
        super(accuracy);
        this.ln = new Ln(accuracy);
    }

    @Override
    public Double calculateFunction(Double x) {
        return ln.calculateFunction(x) / ln.calculateFunction(10.0);
    }

    public Double calculateStub(Double lnStub) {
        return lnStub / ln.getStubsTable().get(10.0);
    }
}
