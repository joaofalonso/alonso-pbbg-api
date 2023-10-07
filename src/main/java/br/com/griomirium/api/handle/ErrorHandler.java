package br.com.griomirium.api.handle;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.boot.json.JsonParseException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404(){
        return ResponseEntity.notFound().build();
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity error400(DataIntegrityViolationException ex){
        System.out.println("JPA catch the exception");
        var dto = new ErrorResponseMessage(ex);
        return ResponseEntity.badRequest().body(dto);
    }
}
