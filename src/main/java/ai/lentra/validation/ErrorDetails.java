package ai.lentra.validation;

public class ErrorDetails {
    private String exception;
    private String message;
    private String details;

    @Override
    public String toString() {
        return exception+":::"+message+" :::"+details;
    }

    public ErrorDetails(String exception, String message, String details) {
        super();
        this.exception = exception;
        this.message = message;
        this.details = details;
    }
    }