package sample.adapter.secondary.mock;

public class MockRateException extends RuntimeException {
    public MockRateException() {
    }

    public MockRateException(String message) {
        super(message);
    }

    public MockRateException(Throwable cause) {
        super(cause);
    }

    public MockRateException(String message, Throwable cause) {
        super(message, cause);
    }
}
