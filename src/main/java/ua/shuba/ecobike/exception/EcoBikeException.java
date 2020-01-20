package ua.shuba.ecobike.exception;

public class EcoBikeException extends RuntimeException {
    public EcoBikeException(String message) {
        super(message);
    }

    public EcoBikeException(String message, Throwable cause) {
        super(message, cause);
    }
}
