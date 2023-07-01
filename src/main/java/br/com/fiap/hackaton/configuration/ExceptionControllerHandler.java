package br.com.fiap.hackaton.configuration;

import br.com.fiap.hackaton.exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionControllerHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity errorMovieNotFound(MovieNotFoundException ex){
        ErrorMessageResponse error = new ErrorMessageResponse(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                ex.getDescription()
        );

        return new ResponseEntity(error, HttpStatus.NOT_FOUND);

    }
}
