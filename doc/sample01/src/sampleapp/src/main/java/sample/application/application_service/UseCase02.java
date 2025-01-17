package sample.application;

import sample.application.domain.*;

public class UseCase02 implements IService {

    RateRepositoryInterface rateRepository;

    public UseCase02(RateRepositoryInterface rateRepository) {
        this.rateRepository = rateRepository;
    }

    public CalculationResult calculation(int input) {
        RateEntity rate = rateRepository.read(input);
        double rateValue = rate.getRate();
        
        CalculationResult resultValue = new CalculationResult(input * rateValue * 2, rateValue);
        
        return resultValue;
    }
}
