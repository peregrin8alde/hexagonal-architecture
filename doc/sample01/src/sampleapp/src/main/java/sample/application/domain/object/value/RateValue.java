package sample.application.domain;

public class RateValue {
    private final double data;

    public RateValue(double data) {
        this.data = data;
    }

    public double getData() {
        return data;
    }

    private void validation() {
        // 不当な理由に応じた例外を発生させる
    }
}
