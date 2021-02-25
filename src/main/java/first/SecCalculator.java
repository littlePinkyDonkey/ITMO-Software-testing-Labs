package first;

public class SecCalculator {

    public Double calculateSec(Double x) {
        Double xn = 1.0, prevSum = 0.0, sum = 1.0;
        final double EPS = 1e-10, INF = 1.0e8;

        for(int n = 0; Math.abs(sum - prevSum) > EPS; n++) {
            prevSum = sum;
            xn *= (-1.0 * x*x / (2*n + 2) / (2*n + 1));
            sum += xn;
        }
        return Math.abs(1/sum) > INF ? INF : 1/sum;
    }
}
