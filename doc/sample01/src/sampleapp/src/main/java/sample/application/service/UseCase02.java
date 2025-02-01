package sample.application.service;

import sample.application.domain.exception.*;
import sample.application.domain.object.entity.RateEntity;
import sample.application.domain.object.value.*;
import sample.application.domain.repository.RateRepositoryInterface;
import sample.application.domain.service.CalculationService;

public class UseCase02 implements ApplicationServiceInterface {

    RateRepositoryInterface rateRepository;

    public UseCase02(RateRepositoryInterface rateRepository) {
        this.rateRepository = rateRepository;
    }

    public ApplicationResult calculation(int input) {
        ApplicationResult result;
        try {
            CalculationInput inputValue = new CalculationInput(input);
            RateEntity rateEntity = rateRepository.read(input);
            CalculationResult resultValue = CalculationService.calculation(inputValue, rateEntity);

            result = new ApplicationResult(resultValue.getValue() * 2, rateEntity.getRate());
        } catch (DomainException e) {
            // 復帰値で表現するパターン
            result = new ApplicationResult(8, "Application Error !!");
        }

        return result;
    }
}
