package andrei.teplyh;

import andrei.teplyh.logarithmic.LogarithmFunction;
import andrei.teplyh.trigonometric.TrigonometricFunction;

public class SystemSolver {
    private TrigonometricFunction trigonometricFunction;
    private LogarithmFunction logarithmFunction;

    public SystemSolver(TrigonometricFunction trigonometricFunction, LogarithmFunction logarithmFunction) {
        this.trigonometricFunction = trigonometricFunction;
        this.logarithmFunction = logarithmFunction;
    }

    public double calculate(Double x) {
        if (x <= 0) {
            return trigonometricFunction.calculateTrigFunction(x);
        } else {
            return logarithmFunction.calculateLogFunction(x);
        }
    }
}
