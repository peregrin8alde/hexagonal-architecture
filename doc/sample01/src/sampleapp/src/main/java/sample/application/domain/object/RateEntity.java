package sample.application.domain;

public class RateEntity {
    private int id;
    private double rate;

    public RateEntity(int id, double rate) {
        this.id = id;
        this.rate = rate;
    }

    public double getRate() {
        return this.rate;
    }

}
