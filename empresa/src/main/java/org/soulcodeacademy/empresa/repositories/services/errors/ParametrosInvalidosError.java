package org.soulcodeacademy.empresa.repositories.services.errors;

public class ParametrosInvalidosError extends RuntimeException{

    public ParametrosInvalidosError(String message){
        super(message);
    }
}
