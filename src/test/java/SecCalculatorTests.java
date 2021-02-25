import first.SecCalculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("First task tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SecCalculatorTests {
    private final SecCalculator calculator = new SecCalculator();
    private final double DELTA = 0.001;

    @ParameterizedTest(name = "Calculate sec({0})")
    @CsvFileSource(resources = "data.csv")
    void test(Double expectedResult, Integer denominator, Integer numerator) {
        System.out.printf("res = %f, denominator = %d", expectedResult, denominator);
        assertEquals(expectedResult, calculator.calculateSec(numerator * Math.PI / denominator), DELTA);
    }
}
