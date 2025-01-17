package sample.application;

import sample.application.domain.*;

public class UseCase01 implements IService {

    RateRepositoryInterface rateRepository;

    public UseCase01(RateRepositoryInterface rateRepository) {
        this.rateRepository = rateRepository;
    }

    public CalculationResult calculation(int input) {
        RateEntity rate = rateRepository.read(input);
        double rateValue = rate.getRate();
        
        CalculationResult resultValue = new CalculationResult(input * rateValue, rateValue);
        
        return resultValue;
    }
}
