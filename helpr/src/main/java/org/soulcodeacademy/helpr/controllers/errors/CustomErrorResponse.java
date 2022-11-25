package org.soulcodeacademy.helpr.controllers.errors;


import java.time.LocalDateTime;

// esta classe customiza a resposta de erro original do Spring
public class CustomErrorResponse {
    private String message; // mensagem explicando o erro
    private Integer status; // código de status http
    private LocalDateTime timeStamp; // registro de data e hora em que o erro aconteceu
    private String path; // endpoint em que ocorreu o erro



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
