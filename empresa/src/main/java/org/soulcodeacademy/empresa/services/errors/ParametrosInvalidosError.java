package org.soulcodeacademy.empresa.services.errors;

public class ParametrosInvalidosError extends RuntimeException{

    public ParametrosInvalidosError(String message){
        super(message);
    }
}
