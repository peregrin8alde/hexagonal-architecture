package sample.application.service;

import sample.application.domain.exception.*;
import sample.application.domain.object.entity.RateEntity;
import sample.application.domain.object.value.*;
import sample.application.domain.port.primary.IService;
import sample.application.domain.port.secondary.*;
import sample.application.exeption.ApplicationException;

public class UseCase02 implements IService {

    RateRepositoryInterface rateRepository;

    public UseCase02(RateRepositoryInterface rateRepository) {
        this.rateRepository = rateRepository;
    }

    public CalculationResult calculation(int input) {
        RateEntity rate = rateRepository.read(input);
        double rateValue = rate.getRate();
        
        CalculationResult resultValue;
        try {
            resultValue = new CalculationResult(input * rateValue * 2, rateValue);

            return resultValue;
        } catch (DomainException e) {
            throw new ApplicationException(e);
        }
    }
}
