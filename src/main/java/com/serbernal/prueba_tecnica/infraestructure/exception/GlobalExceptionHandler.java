package com.serbernal.prueba_tecnica.infraestructure.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = {NoSuchElementException.class})
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public Map<String, String> handleResourceNoSuchElementException(final NoSuchElementException ex) {
    final Map<String, String> errorDetails = new HashMap<>();
    errorDetails.put("message", ex.getMessage());
    return errorDetails;
  }

}
