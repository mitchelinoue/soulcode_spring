package org.soulcodeacademy.empresa.controllers.errors;

import org.soulcodeacademy.empresa.repositories.services.errors.ParametrosInvalidosError;
import org.soulcodeacademy.empresa.repositories.services.errors.RecursoNaoEncontradoError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoError.class)
    public ResponseEntity<CustomErrorResponse> recursoNaoEncontradoError(RecursoNaoEncontradoError erro, HttpServletRequest request){
        CustomErrorResponse response = new CustomErrorResponse();

        response.setTimeStamp(LocalDateTime.now());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(erro.getMessage());
        response.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ParametrosInvalidosError.class)
    public ResponseEntity<CustomErrorResponse> parametrosInsuficientesError(ParametrosInvalidosError erro, HttpServletRequest request){
        CustomErrorResponse response = new CustomErrorResponse();

        response.setTimeStamp(LocalDateTime.now());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(erro.getMessage());
        response.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }


}
