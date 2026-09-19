package model.exceptions;

public class SalarioInvalidoException extends Exception {
    public SalarioInvalidoException(String message) {
        super(message);
    }

    public SalarioInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public SalarioInvalidoException(Throwable cause) {
        super(cause);
    }
    public SalarioInvalidoException() {
        super();
    }
}
