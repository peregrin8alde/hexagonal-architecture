package sample.application.domain;

public class Input {
    private final int value;

    public Input(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validation() {
        // 不当な理由に応じた例外を発生させる
    }
}
