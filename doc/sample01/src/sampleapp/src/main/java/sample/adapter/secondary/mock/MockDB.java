package sample.adapter.mock;

import sample.application.domain.*;

public class MockDB implements IRateRepository {

    public MockDB() {

    }

    public RateEntity read(int id) {
        if (id <= 100) {
            return new RateEntity(id, 1.01);
        } else {
            return new RateEntity(id, 1.5);
        }

    }
}
