package sample.application.domain.object.entity;

import sample.application.domain.exception.*;

public class RateEntity {
    private int id;
    private double rate;

    public RateEntity(int id, double rate) throws DomainException {
        this.id = id;
        this.rate = rate;
        validate();
    }

    public int getId() {
        return id;
    }

    public double getRate() {
        return rate;
    }

    private void validate() throws DomainException {
        // 不当な理由に応じた例外を発生させる
        
    }

}
