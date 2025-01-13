package sample.application.domain;

public class ResultValue {
    private double data;
    private double rate;

    public ResultValue(double data, double rate) {
        this.data = data;
        this.rate = rate;
    }

    public double getData() {
        return this.data;
    }
}
