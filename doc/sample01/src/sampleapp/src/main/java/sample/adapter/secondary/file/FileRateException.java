package sample.adapter.secondary.file;

public class FileRateException extends RuntimeException {
    public FileRateException() {
    }

    public FileRateException(String message) {
        super(message);
    }

    public FileRateException(Throwable cause) {
        super(cause);
    }

    public FileRateException(String message, Throwable cause) {
        super(message, cause);
    }
}
