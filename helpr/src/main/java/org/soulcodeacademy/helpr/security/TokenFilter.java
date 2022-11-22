package org.soulcodeacademy.helpr.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// TokenFilter irá verificar o token do cliente uma vez por requisição
@Component
public class TokenFilter extends OncePerRequestFilter {

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UsuarioSecurityService service;


    // esse método é chamado para toda requisição feita pelo cliente
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // passo 1
        if(!validarCabecalho(request)){
            filterChain.doFilter(request, response);
            return;
        }

        // passo 2
        String token = this.extrairToken(request);

        // passo 3
        if(!this.tokenUtil.validarToken(token)){
            filterChain.doFilter(request, response);
            return;
        }

        // passo 4
        String email = this.tokenUtil.extrairEmail(token);
        UserDetails usuario = this.service.loadUserByUsername(email);

        //configura o usuário encontrado como autenticado na aplicação
        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(
                        usuario.getUsername(),
                        usuario.getPassword(),
                        usuario.getAuthorities()));

        filterChain.doFilter(request, response);


        // Resumo: Extrair do cabeçalho as informações do token,
        // com base nessas informações busca dados do usuário e então indica
        // para a segurança da aplicação que o usuário é válido.
        // Os próximos filtros já irão conhecer usuário e permitir o acesso

    }


    // Passo 1 & 2 (ver se existe o Authorization / ver se está no formato Bearer)
    private boolean validarCabecalho(HttpServletRequest request){
        // extrai do cliente o cabecalho com o possivel token
        String cabecalho = request.getHeader("Authorization");

        // o cabecalho enviado pelo cliente é válido se possuir o authorization e o valor começar com "Bearer ....."
        return cabecalho != null && cabecalho.startsWith("Bearer");
    }


    // passo 3 (ver se JWT é válido)
    private String extrairToken(HttpServletRequest request){

        // "Bearer <JWT>
        String cabecalho = request.getHeader("Authorization");

        return cabecalho.substring(7); // retorna apenas o código do JWT
    }



}
