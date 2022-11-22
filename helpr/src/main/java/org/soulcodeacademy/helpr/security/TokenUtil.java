package org.soulcodeacademy.helpr.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;


// O objetivo dessa classe é: validar JWT, gerar JWT e extrair dados do JWT
@Component // essa anotação vai instanciar automaticamente o tokenUtil
public class TokenUtil {
//    public static void main(String[] args){
//        String senha = "senhatop";
//        String token = JWT.create()
//                .withSubject("jr@gmail.com") // de quem pertence o token
//                .withClaim("name","batata") // informações adicionais
//                .sign(Algorithm.HMAC512(senha)); //
//        System.out.println(token);
//        String email = JWT.require(Algorithm.HMAC512(senha)).build().verify(token).getSubject();
//        String batata = JWT.require(Algorithm.HMAC512(senha)).build().verify(token).getClaim("name").asString();
//        System.out.println(email);
//        System.out.println(batata);
//    }
    @Value("${senhaJwt}") // injeta o valor da variável no campo abaixo (aplication.properties)
    private String senhaJwt;

    @Value("${validadeJwt}")
    private Long validadeJwt;


    public String gerarToken(String email, String perfil){
        // System.currentTimeMillis() = > pega o momento atual em ms
        // new Date(System.currentTimeMillis() + this.validadeJwt) => indica a data futura que o token vai expirar
        return JWT.create()
                .withSubject(email)
                .withClaim("perfil", perfil)
                .withExpiresAt(new Date(System.currentTimeMillis() + this.validadeJwt))
                .sign(Algorithm.HMAC512(this.senhaJwt));
    }

    public String extrairEmail(String token){
        return JWT.require(Algorithm.HMAC512(this.senhaJwt))
                .build()
                .verify(token)
                .getSubject();
    }

    public Boolean validarToken(String token){
        // caso ocorra erro na linha 41, o token passado é inválido (não foi gerado por nós ou expirou)
        try {
            JWT.require(Algorithm.HMAC512(this.senhaJwt))
                    .build()
                    .verify(token);
            return true;
        } catch(JWTVerificationException ex) {
            return false;
        }
    }

}
