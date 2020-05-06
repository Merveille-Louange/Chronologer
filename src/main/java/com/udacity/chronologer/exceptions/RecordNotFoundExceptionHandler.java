package com.udacity.chronologer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class RecordNotFoundExceptionHandler {

    @ExceptionHandler(value = {RecordNotFoundException.class})
    public ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException e){
        //1.Create payload containing exception details
        HttpStatus badRequest=HttpStatus.BAD_REQUEST;
           RecordException recordException= new RecordException(e.getMessage(),

                   badRequest,
                    ZonedDateTime.now(ZoneId.of("Z")));
        //2.Return Response entity

        return new ResponseEntity<>(recordException, badRequest);
    }
}
