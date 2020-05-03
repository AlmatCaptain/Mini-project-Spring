package kz.iitu.reservation.exeption;

import kz.iitu.reservation.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Component
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<Response> handleNullPointerException(NullPointerException e) {
        log.error("Exception handled: " + e.getMessage(), e);
        Response errorResponse = new Response("NullPointerException", e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public ResponseEntity<Response> handleAnyException(Exception e) {
        log.error("Exception handled: " + e.getMessage(), e);
        Response errorResponse = new Response("INTERNAL_SERVER_ERROR",
                "Server error! Repeat later!");

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
