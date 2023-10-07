package br.com.griomirium.api.handle;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.FieldError;

public record ErrorResponseMessage(String error, String message) {

    public ErrorResponseMessage(DataIntegrityViolationException ex){
        this(ex.getMessage(), ex.getMessage());
    }
}
