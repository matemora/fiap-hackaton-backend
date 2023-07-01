package br.com.fiap.hackaton.exception;

import lombok.Getter;

@Getter
public class MovieNotFoundException extends RuntimeException{
    private String description;

    public MovieNotFoundException(String message, String description){
        super(message);
        this.description = description;
    }

}
