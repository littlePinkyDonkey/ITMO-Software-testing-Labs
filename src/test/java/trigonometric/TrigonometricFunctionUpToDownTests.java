package trigonometric;

import andrei.teplyh.trigonometric.CosCalculator;
import andrei.teplyh.trigonometric.SecCalculator;
import andrei.teplyh.trigonometric.TrigonometricFunction;
import andrei.teplyh.util.CsvLogger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Trigonometric function")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TrigonometricFunctionUpToDownTests {
    private TrigonometricFunction trigonometricFunction;
    private SecCalculator secCalculator;
    private CosCalculator cosCalculator;
    private CsvLogger logger = new CsvLogger("trig_results/cos-results.csv", -15.0, 0.0, 0.5);
    private final double ACCURACY = 0.001;
    private final double DELTA = 0.05;

    @BeforeAll
    void init() {
        this.cosCalculator = new CosCalculator(ACCURACY);
        this.secCalculator = new SecCalculator(ACCURACY);
        this.trigonometricFunction = new TrigonometricFunction(ACCURACY);
    }

    @ParameterizedTest(name = "X = {0} * PI / {1}")
    @CsvFileSource(resources = "/trig/trig-data.csv")
    @DisplayName("sec(x) is a stub")
    void secCalculatorIsStub(Double numerator, Double denominator, Double expectedResult) {
        double x = numerator * PI / denominator;

        double secStub = secCalculator.getStubsTable().get(x);

        try {
            double actualResult = trigonometricFunction.calculateTrigFunctionStub(x, secStub);
            System.out.println(actualResult);
            assertEquals(expectedResult, actualResult, DELTA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @ParameterizedTest(name = "X = {0} * PI / {1}")
    @CsvFileSource(resources = "/trig/trig-data.csv")
    @DisplayName("cos(x) is a stub; sec(x) isn't a stub")
    void cosCalculatorIsStub(Double numerator, Double denominator, Double expectedResult) {
        double x = numerator * PI / denominator;

        double cosStub = cosCalculator.getStubsTable().get(x);

        double secCalculatorStubResult = secCalculator.calculateStub(cosStub);

        try {
            double actualResult = trigonometricFunction.calculateTrigFunctionStub(x, secCalculatorStubResult);
            System.out.println(actualResult);
            assertEquals(expectedResult, actualResult, DELTA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @ParameterizedTest(name = "X = {0} * PI / {1}")
    @CsvFileSource(resources = "/trig/trig-data.csv")
    @DisplayName("All calculators aren't stubs")
    void nothingIsStub(Double numerator, Double denominator, Double expectedResult) {
        try {
            double actualResult = trigonometricFunction.calculateFunction(numerator * PI / denominator);
            System.out.println(actualResult);
            assertEquals(expectedResult, actualResult, DELTA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    void log() {
        logger.log(cosCalculator);

        logger.setFilePath("trig_results/sec-results.csv");
        logger.log(secCalculator);

        logger.setFilePath("trig_results/function-results.csv");
        logger.log(trigonometricFunction);
    }
}
