package ai.lentra.modal.responses;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseDTO {
    private String Status;
    private HttpStatus code;
    private String message;

}
