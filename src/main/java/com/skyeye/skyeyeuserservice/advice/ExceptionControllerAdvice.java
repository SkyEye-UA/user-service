package com.skyeye.skyeyeuserservice.advice;

import com.skyeye.skyeyeuserservice.exception.NoSuchUserException;
import com.skyeye.skyeyeuserservice.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

  @ExceptionHandler(NoSuchUserException.class)
  public ResponseEntity<ErrorResponse> handleNoSuchUserException(
      NoSuchUserException noSuchUserException) {
    log.info(noSuchUserException.getMessage());

    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(new ErrorResponse("Entity not found", noSuchUserException.getMessage()));
  }
}
