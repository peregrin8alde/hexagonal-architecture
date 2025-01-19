package sample.application.domain.port.secondary;

import sample.application.domain.object.entity.RateEntity;

public interface RateRepositoryInterface {
    public RateEntity read(int id);
}
