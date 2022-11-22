package org.soulcodeacademy.helpr.security;


import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// Esta classe serve de ponte para comunicação entre a persistência e o framework Spring Security
public class UsuarioSecurity implements UserDetails {

    // Dados de autenticação
    private String email;
    private String senha;

    //Dados de autorização
    private Perfil perfil;
    private ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>(); // Armazena as permissões/autoridades do usuário

    public UsuarioSecurity(String email, String senha, Perfil perfil){
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
        // Adiciona a descrição do perfil como uma role do usuário
        this.authorities.add(new SimpleGrantedAuthority(perfil.getDescricao()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // indica para o security as permissões/papéis do meu usuário
        return this.authorities;
    }

    @Override
    public String getPassword() { // indica pra o Security que nosso usuário possui a senha abaixo
        return this.senha;
    }

    @Override
    public String getUsername() { // indica para o security que nosso usuário possui o email abaixo
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() { // flag que indica se a conta está válida
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // flag que indica se a conta esta desbloqueada
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // flag que indica se as credenciais estão válidas
        return true;
    }

    @Override
    public boolean isEnabled() { // flag que indica se o usuário está habilitado
        return true;
    }

    // indicamos por meios dos getters o estado de autenticação/autorização dos nosso usuarios salvos no banco de dados


}
