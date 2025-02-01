package sample.application.domain.service;

import sample.application.domain.exception.DomainException;
import sample.application.domain.object.entity.RateEntity;
import sample.application.domain.object.value.*;

public class CalculationService {
    public static CalculationResult calculation(CalculationInput inputValue, RateEntity rateEntity) throws DomainException {
        CalculationResult resultValue = new CalculationResult(inputValue.getValue() * rateEntity.getRate());

        return resultValue;
    }
}
