package andrei.teplyh.logarithmic;

public class LogarithmFunction {
    private Ln ln;
    private Log2 log2;
    private Log3 log3;
    private Log5 log5;
    private Log10 log10;

    public LogarithmFunction(
            Ln ln,
            Log2 log2,
            Log3 log3,
            Log5 log5,
            Log10 log10
    ) {
        this.ln = ln;
        this.log2 = log2;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
    }

    /**
     * (((((ln(3.0) + log10(3.0)) - (log2(3.0) * log3(3.0))) ^ 3) - ln(3.0)) + (((log3(3.0) / log10(3.0)) * ln(3.0)) / ((log10(3.0) + log2(3.0)) / (log2(3.0) - log5(3.0)))))
     **/
    public double calculateLogFunction(Double x) throws IllegalArgumentException {
        if (x <= 0.0) {
            throw new IllegalArgumentException("X должен быть больше нуля");
        }

        double lnResult = ln.calculateFunction(x);
        double log2Result = log2.calculateFunction(x);
        double log3Result = log3.calculateFunction(x);
        double log5Result = log5.calculateFunction(x);
        double log10Result = log10.calculateFunction(x);

        return (Math.pow((lnResult + log10Result) - (log2Result * log3Result), 3) - lnResult) +
                (
                        ((log3Result / log10Result) * lnResult) /
                                (
                                        (log10Result + log2Result) / (log2Result - log5Result)
                                )
                );

    }
}
