package org.soulcodeacademy.helpr.controllers.errors;
import org.soulcodeacademy.helpr.services.errors.ParametrosInsuficientesError;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;


// quando acontece um erro, essa classe decide como retornar a mensagem para o cliente
@ControllerAdvice // capacidade de gerenciar os erros que acontecem
public class ResourceExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoError.class)
    public ResponseEntity<CustomErrorResponse> recursoNaoEncontradoError(RecursoNaoEncontradoError erro, HttpServletRequest request){
        CustomErrorResponse response = new CustomErrorResponse();

        response.setTimeStamp(LocalDateTime.now()); // define a data e hora em que o erro ocorreu
        response.setStatus(HttpStatus.NOT_FOUND.value()); // define como 404 o código de status
        response.setMessage(erro.getMessage()); // define a mensagem de erro vindo do service
        response.setPath(request.getRequestURI()); // define qual o endpoint ocorreu a requisição

        // retorna o objeto com os dados e código 404
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ParametrosInsuficientesError.class)
    public ResponseEntity<CustomErrorResponse> parametrosInsuficientesError(ParametrosInsuficientesError erro, HttpServletRequest request){
        CustomErrorResponse response = new CustomErrorResponse();

        response.setTimeStamp(LocalDateTime.now());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(erro.getMessage());
        response.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<CustomErrorResponse> badCredentialsException(BadCredentialsException erro, HttpServletRequest request){
        CustomErrorResponse response = new CustomErrorResponse();
        response.setTimeStamp(LocalDateTime.now());
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setMessage("E-mail/senha inválidos");
        response.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);

    }


}
