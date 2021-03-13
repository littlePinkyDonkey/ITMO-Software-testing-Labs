package andrei.teplyh.util;

public class FactorialSeries {

    public static Double factorial(int n) {
        Double ret;

        if (n == 0) {
            return 1.0;
        } else {
            ret = n * factorial(n - 1);
        }
        return ret;
    }
}
