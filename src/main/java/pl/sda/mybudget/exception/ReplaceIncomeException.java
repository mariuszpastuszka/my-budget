package pl.sda.mybudget.exception;

public class ReplaceIncomeException extends RuntimeException {
    public ReplaceIncomeException() {
    }

    public ReplaceIncomeException(String message) {
        super(message);
    }

    public ReplaceIncomeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReplaceIncomeException(Throwable cause) {
        super(cause);
    }

    public ReplaceIncomeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
