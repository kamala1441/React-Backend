package com.rejola.BProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    ZoneId zoneId = ZoneId.of("Asia/Kolkata");


    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException e) {
        ExceptionMessage message = new ExceptionMessage(
                e.getMessage(),
                false,
                404,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(zoneId)
        );
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

    }

/*  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleException(Exception e) {
    ExceptionMessage message =  new ExceptionMessage(
            "Something went wrong",
            false,
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            HttpStatus.INTERNAL_SERVER_ERROR,
            ZonedDateTime.now(zoneId)
    );
    return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
  }*/

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<Object> InvalidTokenException(InvalidTokenException e) {
        ExceptionMessage message = new ExceptionMessage(
                e.getMessage(),
                false,
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED,
                ZonedDateTime.now(zoneId)
        );
        return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> runtime(RuntimeException e) {
        ExceptionMessage message = new ExceptionMessage(
                e.getMessage(),
                false,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                ZonedDateTime.now(zoneId)
        );
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException e) {
        ExceptionMessage message = new ExceptionMessage(
                e.getMessage(),
                false,
                401,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(zoneId)
        );
        return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleBadRequestException(UserNotFoundException e) {
        ExceptionMessage message = new ExceptionMessage(
                e.getMessage(),
                false,
                401,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(zoneId)
        );
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<Object> handleAlreadyExistException(AlreadyExistException e) {
        ExceptionMessage message = new ExceptionMessage(
                e.getMessage(),
                false,
                401,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(zoneId)
        );
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

}
