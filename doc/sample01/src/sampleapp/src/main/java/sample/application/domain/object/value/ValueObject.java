package sample.application.domain;

public abstract class ValueObject<T> {
    // 値は不変
    private final T value;

    public ValueObject(T value) {
        this.validate(value);
        this.value = value;
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
        if (obj == null || getClass() != obj.getClass()) return false;
        // 各フィールドの比較
        ValueObject<T> valueObject = (ValueObject<T>) obj;
        return Objects.equals(value, valueObject.getValue());
    }
    // equals をオーバーライドする場合は hashCode もオーバーライドする必要がある
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    // 不当な理由に応じた例外を発生させる
    abstract void validate(T value);
}
