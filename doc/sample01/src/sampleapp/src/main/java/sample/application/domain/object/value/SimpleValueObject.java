package sample.application.domain.object.value;

import sample.application.domain.exception.*;

import java.util.Objects;

public abstract class SimpleValueObject<T> {
    // 値は不変
    // サブクラスからも getter を使わないとアクセス不可なのに注意
    private final T value;

    public SimpleValueObject(T value) throws DomainException {
        // 実装側で検証を実施
        validate(value);
        // 検証時に前処理した後の値を設定したい場合は？
        // value 自体は不変の想定なので、前処理が必要ならファクトリを用意するべきか？
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

    // サブクラス側で前処理や検証などを実装する中で getter 経由で value を取得させるよりは
    // 検証処理に value を渡した方が良さそう。 super() 内で this.value 設定時点で正しい値であることは保障されるべき
    // 実装側で override したいので private は不可
    abstract public void validate(T value) throws DomainException;
}
