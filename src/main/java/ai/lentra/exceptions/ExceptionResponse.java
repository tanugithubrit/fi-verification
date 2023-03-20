package ai.lentra.exceptions;

import java.time.LocalDateTime;

public class ExceptionResponse {

    public ExceptionResponse(LocalDateTime dateTime, String validationFailed, String toString) {
    }

    public record ExceptionResponse1(LocalDateTime timestamp,
                                    String message,
                                    String details) {

    }
}
