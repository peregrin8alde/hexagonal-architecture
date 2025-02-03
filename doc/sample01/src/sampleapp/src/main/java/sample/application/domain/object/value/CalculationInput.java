package sample.application.domain.object.value;

import sample.application.domain.exception.*;

public class CalculationInput extends SimpleValueObject<Integer> {
    public CalculationInput(Integer value) throws DomainException {
        super(value);
    }

    @Override
    public void validate(Integer value) throws DomainException {
        // 不当な理由に応じた例外を発生させる
        // 制約違反時の動作確認用の仮ルール
        if (value >= 300) {
            throw new DomainException(value + " is invalid input!!");
        }
        
    }

}
