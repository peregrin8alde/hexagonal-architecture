package sample.application.domain;

public class InputValue {
    private final int data;

    public InputValue(int data) {
        this.data = data;
    }

    public int getValue() {
        return data;
    }

    private void validation() {
        // 不当な理由に応じた例外を発生させる
    }
}
