package sample.application.domain.object.value;

import sample.application.domain.exception.*;

public class CalculationInput extends SimpleValueObject<Integer> {
    public CalculationInput(Integer value) throws DomainException {
        super(value);
        validate();
    }

    @Override
    public void validate() throws DomainException {
        // 不当な理由に応じた例外を発生させる
        
    }

}
