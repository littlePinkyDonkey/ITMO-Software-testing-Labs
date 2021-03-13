package andrei.teplyh;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public abstract class AbstractFunction {
    private final Double DEFAULT_ACCURACY = 0.000001;
    private Map<Double, Double> stubsTable = new HashMap<>();
    private Double accuracy;

    public AbstractFunction() {
        this.accuracy = DEFAULT_ACCURACY;
    }

    public AbstractFunction(Double accuracy) {
        this.accuracy = accuracy;
    }

    public abstract Double calculateFunction(Double x);
}
