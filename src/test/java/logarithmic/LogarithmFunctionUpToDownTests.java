package logarithmic;

import andrei.teplyh.logarithmic.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Logarithm function")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogarithmFunctionUpToDownTests {
    private LogarithmFunction logarithmFunction;
    private Ln ln;
    private Log2 log2;
    private Log3 log3;
    private Log5 log5;
    private Log10 log10;
    private final double DELTA = 0.05;
    private final double ACCURACY = 0.001;

    @BeforeAll
    void init() {
        this.ln = new Ln(ACCURACY);
        this.log2 = new Log2(ACCURACY);
        this.log3 = new Log3(ACCURACY);
        this.log5 = new Log5(ACCURACY);
        this.log10 = new Log10(ACCURACY);
        this.logarithmFunction = new LogarithmFunction(ln, log2, log3, log5, log10);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 0", "1, NaN"})
    void allLogsAreStubs(Double x, Double expectedResult) {

        double lnStub = ln.getStubsTable().get(x);
        double log2Stub = log2.getStubsTable().get(x);
        double log3Stub = log3.getStubsTable().get(x);
        double log5Stub = log5.getStubsTable().get(x);
        double log10Stub = log10.getStubsTable().get(x);

        try {
            double actualResult = logarithmFunction.calculateStub(x, lnStub, log2Stub, log3Stub, log5Stub, log10Stub);
            System.out.println(actualResult);
            assertEquals(expectedResult, actualResult, DELTA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/log/ln-data.csv")
    void lnIsStub(Double x, Double expectedResult) {
        double lnStub = ln.getStubsTable().get(x);

        double log2Result = log2.calculateStub(lnStub);
        double log3Result = log3.calculateStub(lnStub);
        double log5Result = log5.calculateStub(lnStub);
        double log10Result = log10.calculateStub(lnStub);

        try {
            double actualResult = logarithmFunction.calculateStub(x, lnStub, log2Result, log3Result, log5Result,
                    log10Result);
            System.out.println(actualResult);
            assertEquals(expectedResult, actualResult, DELTA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/log/log-data.csv")
    void allModulesAvailable(Double x, Double expectedResult) {
        try {
            double actualResult = logarithmFunction.calculateLogFunction(x);
            System.out.println(actualResult);
            assertEquals(expectedResult, actualResult, DELTA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }
}
