package com.netflixanalysis.netflixanalysis.controllers;

import com.netflixanalysis.netflixanalysis.domain.dto.GenericApiResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericApiResponse<Object>> handleException(Exception ex){
        GenericApiResponse<Object> error = GenericApiResponse.error(ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<GenericApiResponse<Object>> handleIllegalArgumentException(IllegalArgumentException ex){
        GenericApiResponse<Object> error = GenericApiResponse.error(ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<GenericApiResponse<Object>> handleEntityNotFoundException(EntityNotFoundException ex){
        GenericApiResponse<Object> error = GenericApiResponse.error(ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<GenericApiResponse<Object>> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex){
        GenericApiResponse<Object> error = GenericApiResponse.error(ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MissingRequestValueException.class)
    public ResponseEntity<GenericApiResponse<Object>> handleMissingRequestValueException(MissingRequestValueException ex){
        GenericApiResponse<Object> error = GenericApiResponse.error(ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<GenericApiResponse<Object>> handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex){
        GenericApiResponse<Object> error = GenericApiResponse.error(ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoSuchFieldException.class)
    public ResponseEntity<GenericApiResponse<Object>> handleNoSuchFieldException(NoSuchFieldException ex){
        GenericApiResponse<Object> error = GenericApiResponse.error(ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }




}
