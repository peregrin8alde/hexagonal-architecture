package sample.application.domain;

public class RateEntity {
    private int id;
    private double rate;

    public RateEntity(int id, double rate) {
        this.id = id;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public double getRate() {
        return rate;
    }

}
