package com.jskno.investmentsbe.web.advice;

import com.jskno.investmentsbe.exceptions.EntityConstraintViolationException;
import com.jskno.investmentsbe.exceptions.EntityNotFoundException;
import com.jskno.investmentsbe.servicies.MapperErrorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @Autowired
    MapperErrorsService mapperErrorsService;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handle(MethodArgumentNotValidException ex) {
        return mapperErrorsService.mapArgumentNotValidException(ex);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handle(ConstraintViolationException ex) {
        return mapperErrorsService.mapConstraintViolationException(ex);
    }

    @ExceptionHandler(MissingPathVariableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handle(MissingPathVariableException ex) {
        return mapperErrorsService.mapMissingPathVariableException(ex);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handle(EntityNotFoundException ex) {
        return mapperErrorsService.mapEntityNotFoundException(ex);
    }

    @ExceptionHandler(EntityConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Map<String, String> handle(EntityConstraintViolationException ex) {
        Map<String, String> map = new HashMap<>();
        map.put(ex.getConstraintRule(), ex.getMessage());
        return map;
    }
}
