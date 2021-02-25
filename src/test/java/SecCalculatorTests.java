import first.SecCalculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("First task tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SecCalculatorTests {
    private final SecCalculator calculator = new SecCalculator();
    private final double DELTA = 0.05;
    private final double INFINITY = 1.0E8;

    @ParameterizedTest(name = "Calculate sec({0})")
    @CsvFileSource(resources = "data.csv")
    void dataTest(Double expectedResult, Integer numerator, Integer denominator) {
        double actualResult= calculator.calculateSec(numerator * Math.PI / denominator);

        System.out.printf("expectedResult = %9f | numerator = %3d | denominator = %3d | actualResult = %9f\n",
                expectedResult, numerator, denominator, actualResult);

        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest(name = "Infinity test sec({0})")
    @CsvSource(value = {"1, 2", "-1, 2", "3, 2", "-3, 2"})
    void infinityTest(Integer numerator, Integer denominator) {
        double actualResult = calculator.calculateSec(numerator * Math.PI / denominator);

        System.out.printf("expectedResult = %9f | numerator = %3d | denominator = %3d | actualResult = %9f\n",
                INFINITY, numerator, denominator, actualResult);

        assertEquals(INFINITY, actualResult, DELTA);
    }
}
