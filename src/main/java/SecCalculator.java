public class SecCalculator {

    private Double CalibrateX(Double x) {
        double del = Math.PI * 2;
        if(x < 0)
            del *= -1;
        while(Math.abs(x) > 30.0)
        {
            x -= del;
        }
        return x;
    }

    public Double calcSec(Double x) throws Exception{
        try {
            Double xn = 1.0, prevSum = 0.0, sum = 1.0;
            final Double EPS = 1e-10, INF = 1.0e8;
            x = CalibrateX(x);

            for(Integer n = 0; Math.abs(sum - prevSum) > EPS; n++)
            {
                prevSum = sum;
                xn *= (-1.0 * x*x / (2*n + 2) / (2*n + 1));
                sum += xn;
            }
            return Math.abs(1/sum) > INF ? INF : 1/sum;
        }
        catch (Exception e){
            throw e;
        }
    }
}
