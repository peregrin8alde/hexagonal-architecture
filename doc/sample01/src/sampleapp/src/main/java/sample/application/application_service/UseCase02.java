package sample.application;

import sample.application.domain.*;

public class UseCase02 implements IService {

    IRateRepository rateRepository;

    public UseCase02(IRateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public CalculationResult calculation(int input) {
        RateEntity rate = rateRepository.read(input);
        double rateValue = rate.getRate();
        
        CalculationResult resultValue = new CalculationResult(input * rateValue * 2, rateValue);
        
        return resultValue;
    }
}
