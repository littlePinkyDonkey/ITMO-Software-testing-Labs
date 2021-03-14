import andrei.teplyh.SystemSolver;
import andrei.teplyh.logarithmic.*;
import andrei.teplyh.trigonometric.TrigonometricFunction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("System solver tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SystemSolverTests {
    private SystemSolver systemSolver;
    private final double ACCURACY = 0.001;
    private final double DELTA = 0.05;

    @BeforeAll
    void init() {
        this.systemSolver = new SystemSolver(
                new TrigonometricFunction(ACCURACY),
                new LogarithmFunction(
                        new Ln(ACCURACY),
                        new Log2(ACCURACY),
                        new Log3(ACCURACY),
                        new Log5(ACCURACY),
                        new Log10(ACCURACY)
                )
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/system-data.csv")
    void systemSolverTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, systemSolver.calculate(x), DELTA);
    }
}
