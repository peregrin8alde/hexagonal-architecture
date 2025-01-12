package sample.adapter;

import sample.application.domain.*;

public class MockDB implements IRateRepository {

    public MockDB() {

    }

    public int create(double rate) {
        int id = 1;

        RateEntity rateEntity = new RateEntity(id, rate);

        return id;
    }

    public RateEntity read(int id) {
        if (id <= 100) {
            return new RateEntity(id, 1.01);
        } else {
            return new RateEntity(id, 1.5);
        }

    }
}
