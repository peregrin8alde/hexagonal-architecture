package sample.application;

import sample.application.domain.*;

public class UseCase01 implements IService {

    IRateRepository rateRepository;

    public UseCase01(IRateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public ResultValue calculation(int input) {
        RateEntity rate = rateRepository.read(input);
        double rateValue = rate.getRate();
        
        ResultValue resultValue = new ResultValue(input * rateValue, rateValue);
        
        return resultValue;
    }
}
