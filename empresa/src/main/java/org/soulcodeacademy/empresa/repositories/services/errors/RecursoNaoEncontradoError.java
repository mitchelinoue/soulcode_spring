package org.soulcodeacademy.empresa.repositories.services.errors;

public class RecursoNaoEncontradoError extends RuntimeException{

    public RecursoNaoEncontradoError(String message){
        super(message);
    }
}
