package sample.application.service;

import sample.application.domain.exception.*;
import sample.application.domain.object.entity.RateEntity;
import sample.application.domain.object.value.*;
import sample.application.domain.repository.RateRepositoryInterface;
import sample.application.domain.service.CalculationService;
import sample.application.exeption.ApplicationException;

public class UseCase01 implements ApplicationServiceInterface {

    RateRepositoryInterface rateRepository;

    public UseCase01(RateRepositoryInterface rateRepository) {
        this.rateRepository = rateRepository;
    }

    public ApplicationResult calculation(int input) {
        ApplicationResult result;
        try {
            CalculationInput inputValue = new CalculationInput(input);
            RateEntity rateEntity = rateRepository.read(input);
            CalculationResult resultValue = CalculationService.calculation(inputValue, rateEntity);

            result = new ApplicationResult(resultValue.getValue(), rateEntity.getRate());

            return result;
        } catch (DomainException e) {
            // 非検査例外でラッピングするパターン
            throw new ApplicationException(e);
        }
    }
}
