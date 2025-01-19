package sample.application.domain.object.value;

import sample.application.domain.exception.*;

import java.util.Objects;

public abstract class SimpleValueObject<T> {
    // 値は不変
    private final T value;

    public SimpleValueObject(T value) throws DomainException {
        this.value = value;
        validate();
    }

    public T getValue() {
        return value;
    }

    // 値が一致したら同一扱い
    @Override
    public boolean equals(Object obj) {
        // 同一インスタンスなら当然同一
        if (this == obj) return true;
        // 比較対象が null や別クラスなら比較できない
        // 参考 : https://stackoverflow.com/questions/16382887/how-to-implement-equals-method-for-generics-using-instanceof
        if (obj instanceof SimpleValueObject<?>){
            // 各フィールドの比較
            SimpleValueObject<?> valueObject = (SimpleValueObject<?>) obj;
            return Objects.equals(value, valueObject.getValue());
        } else {
            return false;
        }
    }
    // equals をオーバーライドする場合は hashCode もオーバーライドする必要がある
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    abstract public void validate() throws DomainException;
}
