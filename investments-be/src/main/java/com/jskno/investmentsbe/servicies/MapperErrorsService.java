package com.jskno.investmentsbe.servicies;

import com.jskno.investmentsbe.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class MapperErrorsService {

    public Map<String, String> mapArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }

    public Map<String, String> mapConstraintViolationException(ConstraintViolationException ex) {
        return ex.getConstraintViolations().stream().collect(Collectors.toMap(
                x -> x.getMessage().split(Pattern.quote("->"))[0],
                x -> x.getMessage().split(Pattern.quote("->"))[1]
        ));
    }

    public Map<String, String> mapMissingPathVariableException(MissingPathVariableException ex) {
        Map<String, String> map = new HashMap<>();
        map.put(ex.getVariableName(), ex.getMessage());
        return map;
    }

    public Map<String, String> mapEntityNotFoundException(EntityNotFoundException ex) {
        Map<String, String> map = new HashMap<>();
        map.put(ex.getEntityNotFound(), ex.getMessage());
        return map;
    }
}
