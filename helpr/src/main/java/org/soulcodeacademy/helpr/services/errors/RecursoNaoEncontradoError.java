package org.soulcodeacademy.helpr.services.errors;


// esta classe representa o erro de regra de negócio quendo não encontramos cargos, clientes, funcionários, chamados no Banco
public class RecursoNaoEncontradoError extends RuntimeException{
    public RecursoNaoEncontradoError(String message){
        super(message); // passamos a mensagem para a Runtime
    }
}
