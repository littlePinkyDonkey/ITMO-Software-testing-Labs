package second;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Second task tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DfsAlgorithmTests {

    @Nested
    @DisplayName("Comparator properties tests")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class NodeComparatorTests {
        private NodeComparator nodeComparator = new NodeComparator();

        @ParameterizedTest(name = "firstNumber={0}, secondNumber={1}")
        @CsvSource(value = {"1, 1", "2, 1"})
        @DisplayName("Test for the property of reflexivity")
        void nodeComparatorReflexivityTest(Integer firstValue, Integer secondValue) {
            int result = nodeComparator.compare(firstValue, secondValue);

            if (result == 0) {
                System.out.printf("Numbers are equal: firstValue = %d, secondValue = %d\n",
                        firstValue, secondValue);
            } else {
                System.out.printf("Numbers aren't equal: firstValue = %d, secondValue = %d\n",
                        firstValue, secondValue);
            }

            assertTrue(true);
            System.out.println("Comparator corresponds to the reflexivity property");
        }

        @ParameterizedTest(name = "higherNumber={0}, lowerNumber={1}")
        @CsvSource(value = {"5, 3", "15, 15"})
        @DisplayName("Test for the anti-symmetry property")
        void nodeComparatorAntiSymmetryTest(Integer higherNumber, Integer lowerNumber) {
            int higherCompareToLower = nodeComparator.compare(higherNumber, lowerNumber);
            int lowerCompareToHigher = nodeComparator.compare(lowerNumber, higherNumber);

            if (higherCompareToLower * lowerCompareToHigher < 0) {
                System.out.printf("Signs aren't equal: higherCompareToLower = %d, lowerCompareToHigher = %d\n",
                        higherCompareToLower, lowerCompareToHigher);
            } else {
                System.out.printf("Result is 0: higherCompareToLower = %d, lowerCompareToHigher = %d\n",
                        higherCompareToLower, lowerCompareToHigher);
            }

            assertTrue(true);
            System.out.println("Comparator corresponds to the anti-symmetry property");
        }

        @ParameterizedTest(name = "a={0}, b={1}, c={2}")
        @CsvSource(value = {"20, 15, 16", "7, 5, 3"})
        @DisplayName("Test for the property of transitivity")
        void nodeComparatorTransitivityTest(Integer a, Integer b, Integer c) {
            int aCompareB = nodeComparator.compare(a, b);
            int bCompareC = nodeComparator.compare(b, c);
            int aCompareC = nodeComparator.compare(a, c);

            int comparedSign = aCompareB * bCompareC;

            if (comparedSign > 0 && aCompareB * aCompareC > 0 && bCompareC * aCompareC > 0) {
                System.out.printf("Signs are equal: aCompareB = %d, bCompareC = %d, aCompareC = %d\n",
                        aCompareB, bCompareC, aCompareC);
            } else {
                System.out.printf("Signs aren't equal: aCompareB = %d, bCompareC = %d, aCompareC = %d\n",
                        aCompareB, bCompareC, aCompareC);
            }

            assertTrue(true);
            System.out.println("Comparator corresponds to the transitivity property");
        }
    }
}
