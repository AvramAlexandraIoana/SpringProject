package com.example.demo.aspects;

import com.example.demo.utils.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> touristContentValidation(MethodArgumentNotValidException exception) {
        Map<String, Object> body = new HashMap<>();
        List<ObjectError> errors = exception.getAllErrors();
        List<ErrorResponse> bodyResponse = errors.stream()
                            .map(err -> new ErrorResponse(err.getDefaultMessage()))
                            .collect(Collectors.toList());
        body.put("timestamp", LocalDate.now());
        body.put("errors", bodyResponse);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}