package com.starwars.project.util.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<String> handleWebClientException(Exception e) {
        e.printStackTrace();
        String errorMessage="Error while making call to API: " + e.getMessage();
        logger.error(errorMessage);
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<String> handleJsonProcessingExceptionException(Exception e) {
        e.printStackTrace();
        String errorMessage="Error while converting JSON object: " + e.getMessage();
        logger.error(errorMessage);
        ResponseEntity<String> stringResponseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        return stringResponseEntity;
    }
    @ExceptionHandler(StarWarsSequelsException.class)
    public ResponseEntity<String> handleIncorrectMovieIdException(Exception e) {
        logger.error(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
