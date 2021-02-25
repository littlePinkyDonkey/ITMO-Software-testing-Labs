import first.SecCalculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@DisplayName("First task tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SecCalculatorTests {
    private final SecCalculator calculator = new SecCalculator();

    @DisplayName("Calculate sec(x)")
    @ParameterizedTest(name = "sec({0})")
    @CsvFileSource(resources = "data.csv")
    void calculate(Double param) throws InterruptedException {
        System.out.println(calculator.calculateSec(param));
    }
}
