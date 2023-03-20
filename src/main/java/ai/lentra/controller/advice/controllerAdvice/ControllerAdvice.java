package ai.lentra.controller.advice.controllerAdvice;


import ai.lentra.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {
//    to handle the file upload exceptions

    //to handle the dto validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ResponseDTO>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ResponseDTO> responseDTOs = new ArrayList<>();
        Map<String, String> errorMapping = new HashMap<>();
        ResponseDTO errorResponse = new ResponseDTO();
        errorResponse.setCode(HttpStatus.BAD_REQUEST);
        errorResponse.setStatus("Invalid Input Error");

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMapping.put(error.getField(), error.getDefaultMessage());
            errorResponse.setMessage(errorMapping.toString());
            responseDTOs.add(errorResponse);
        });


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTOs);
    }
}
