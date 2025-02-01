package sample.application.domain.repository;

import sample.application.domain.object.entity.RateEntity;

public interface RateRepositoryInterface {
    public RateEntity read(int id);
}
