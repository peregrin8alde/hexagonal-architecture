package sample.application.domain;

public class ResultValue {
    private double value;
    private double rate;

    public ResultValue(double value, double rate) {
        this.value = value;
        this.rate = rate;
    }

    public double getValue() {
        return this.value;
    }
}
