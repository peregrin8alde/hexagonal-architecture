package sample.application.domain;

public class CalculationResult {
    // 値は不変
    private final double result;
    private final double rate;

    // 生成時にバリデーションと値の決定
    public CalculationResult(double result, double rate) {
        this.validate();
        this.result = result;
        this.rate = rate;
    }

    // 値の参照
    public double getResult() {
        return result;
    }

    public double getRate() {
        return rate;
    }

    // 値が一致したら同一扱い
    @Override
    public boolean equals(Object obj) {
        // 同一インスタンスなら当然同一
        if (this == obj) return true;
        // 比較対象が null や別クラスなら比較できない
        if (obj == null || getClass() != obj.getClass()) return false;
        // 各フィールドの比較
        CalculationResult calculationResult = (CalculationResult) obj;
        return result == calculationResult.getStatus()
            && rate == calculationResult.getCalculationResult();
    }
    // equals をオーバーライドする場合は hashCode もオーバーライドする必要がある
    @Override
    public int hashCode() {
        return Objects.hash(result, rate);
    }

    // 不当な理由に応じた例外を発生させる
    private void validate() {

    }

}
