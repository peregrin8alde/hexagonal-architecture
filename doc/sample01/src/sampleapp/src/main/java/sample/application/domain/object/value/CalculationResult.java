package sample.application.domain;

public class CalculationResult {
    private final double value;

    public CalculationResult(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
