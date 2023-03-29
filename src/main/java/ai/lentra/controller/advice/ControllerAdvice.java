package ai.lentra.controller.advice;


import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.*;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {
//    to handle the file upload exceptions
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ResponseDTO> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException exc) {
        ResponseDTO ResponseDTO = new ResponseDTO();
        ResponseDTO.setCode(HttpStatus.BAD_REQUEST);
        ResponseDTO.setStatus("Upload Failed ");
        ResponseDTO.setMessage("File size is exceed than allowed limit (100MB) ");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDTO); //
    }
    //to handle the dto validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ResponseDTO>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ResponseDTO> ResponseDTOs = new ArrayList<>();
        Map<String, String> errorMapping = new HashMap<>();
        ResponseDTO errorResponse= new ResponseDTO();
        errorResponse.setCode(HttpStatus.BAD_REQUEST);
        errorResponse.setStatus("Invalid Input Error");

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMapping.put(error.getField(), error.getDefaultMessage());
            errorResponse.setMessage(errorMapping.toString());
            ResponseDTOs.add(errorResponse);
        });


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDTOs);
    }
    //to handle FileSizeLimitExceededException
    @ExceptionHandler(FileSizeLimitExceededException.class)
    public ResponseEntity<ResponseDTO> handleFileSizeLimitExceededException(FileSizeLimitExceededException exc) {
        ResponseDTO ResponseDTO = new ResponseDTO();
        ResponseDTO.setCode(HttpStatus.BAD_REQUEST);
        ResponseDTO.setStatus("Upload Failed ");
        ResponseDTO.setMessage("File size is exceed than allowed limit (100MB)  ");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDTO); //
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDTO> handleLeadingZeroParseError(HttpMessageNotReadableException exc) {
        ResponseDTO ResponseDTO = new ResponseDTO();
        ResponseDTO.setCode(HttpStatus.BAD_REQUEST);
        ResponseDTO.setStatus("Invalid Input");
        if(exc.getCause().toString().contains("Leading zeroes not allowed")){
            ResponseDTO.setMessage("Invalid Input some of the Field contains leading zeros :");
        }
        if(exc.getCause().toString().contains("`java.math.BigDecimal` from String")){
            ResponseDTO.setMessage("Field contains Special Characters or Alphabets in number fields:");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDTO); //
    }

//    To handle the ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleResourceNotFoundException(ResourceNotFoundException exc) {
        ResponseDTO ResponseDTO = new ResponseDTO();
        ResponseDTO.setCode(HttpStatus.NOT_FOUND);
        ResponseDTO.setStatus("ERROR");
        ResponseDTO.setMessage(exc.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseDTO);
    }
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ResponseDTO> handleDuplicateResource(DuplicateResourceException exc) {
        ResponseDTO ResponseDTO = new ResponseDTO();
        ResponseDTO.setCode(HttpStatus.CONFLICT);
        ResponseDTO.setStatus("Duplicate Request");
        ResponseDTO.setMessage(exc.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ResponseDTO);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<ResponseDTO> handleDateTimeParse(DateTimeParseException exc) {
        ResponseDTO ResponseDTO = new ResponseDTO();
        ResponseDTO.setCode(HttpStatus.BAD_REQUEST);
        ResponseDTO.setStatus("Invalid Input");
        ResponseDTO.setMessage("Date should be in the format of  dd/mm/yyyy");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDTO);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ResponseDTO> handleInvalidInput(InvalidInputException exc) {
        ResponseDTO ResponseDTO = new ResponseDTO();
        ResponseDTO.setCode(HttpStatus.BAD_REQUEST);
        ResponseDTO.setStatus("Invalid Input");
        ResponseDTO.setMessage(exc.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDTO);
    }

    @ExceptionHandler(CurrencyNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleCurrencyExceptions(CurrencyNotFoundException ex) {
        List<ResponseDTO> ResponseDTOs = new ArrayList<>();
        Map<String, String> errorMapping = new HashMap<>();
        ResponseDTO errorResponse= new ResponseDTO();
        errorResponse.setCode(HttpStatus.BAD_REQUEST);
        errorResponse.setStatus("Invalid Input Error");
        errorResponse.setMessage(ex.getMessage());


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(ResidenceException.class)
    public ResponseEntity<ResponseDTO> handleResidenceExceptions(CurrencyNotFoundException ex) {
        List<ResponseDTO> ResponseDTOs = new ArrayList<>();
        Map<String, String> errorMapping = new HashMap<>();
        ResponseDTO errorResponse= new ResponseDTO();
        errorResponse.setCode(HttpStatus.BAD_REQUEST);
        errorResponse.setStatus("Invalid Input Error");
        errorResponse.setMessage(ex.getMessage());


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
