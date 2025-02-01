package sample.adapter.secondary.mock;

import sample.application.domain.exception.DomainException;
import sample.application.domain.object.entity.RateEntity;
import sample.application.domain.repository.RateRepositoryInterface;

public class MockRateRepo implements RateRepositoryInterface {

    public MockRateRepo() {

    }

    public RateEntity read(int id) {
        try {
            if (id <= 100) {
                return new RateEntity(id, 1.01);
            } else {
                return new RateEntity(id, 1.5);
            }
        } catch (DomainException e) {
            throw new MockRateException(e);
        }

    }
}
