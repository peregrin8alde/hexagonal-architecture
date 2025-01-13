package sample.application.domain;

public class ResultValue {
    private double data;
    private double rate;

    public ResultValue(double data, double rate) {
        this.data = data;
        this.rate = rate;
    }

    public double getData() {
        return data;
    }

    public double getRate() {
        return rate;
    }
}
