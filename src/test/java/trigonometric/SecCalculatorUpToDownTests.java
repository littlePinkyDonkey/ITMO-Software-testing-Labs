package trigonometric;

import andrei.teplyh.trigonometric.CosCalculator;
import andrei.teplyh.trigonometric.SecCalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Sec calculator")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SecCalculatorUpToDownTests {
    private SecCalculator secCalculator;
    private CosCalculator cosCalculator;
    private final double DELTA = 0.05;
    private final double ACCURACY = 0.001;

    @BeforeAll
    void init() {
        this.secCalculator = new SecCalculator(ACCURACY);
        this.cosCalculator = new CosCalculator(ACCURACY);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trig/sec-data.csv")
    @DisplayName("cos(x) is a stub")
    void cosIsStub(Double numerator, Double denominator, Double expectedResult) {
        double x = numerator * PI / denominator;

        double cosStub = cosCalculator.getStubsTable().get(x);

        double actualResult = secCalculator.calculateStub(cosStub);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trig/sec-data.csv")
    @DisplayName("cos(x) isn't a stub")
    void cosIsNotStub(Double numerator, Double denominator, Double expectedResult) {
        double x = numerator * PI / denominator;

        double actualResult = secCalculator.calculateFunction(x);
        assertEquals(expectedResult, actualResult, DELTA);
    }
}
