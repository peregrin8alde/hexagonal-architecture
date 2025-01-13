package sample.application;

import sample.application.domain.*;

public class UseCase02 implements IService {

    IRateRepository rateRepository;

    public UseCase02(IRateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public ResultValue calculation(int input) {
        RateEntity rate = rateRepository.read(input);
        double rateValue = rate.getRate();
        
        ResultValue resultValue = new ResultValue(input * rateValue * 2, rateValue);
        
        return resultValue;
    }
}
