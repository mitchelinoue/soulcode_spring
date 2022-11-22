package org.soulcodeacademy.helpr.security;

import org.soulcodeacademy.helpr.domain.Usuario;
import org.soulcodeacademy.helpr.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


// Carregar a entidade do banco de dados e converter para o UsuarioSecurity
@Service
public class UsuarioSecurityService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    // se comunica com o banco de dados em busca do usuário que tem username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // vai buscar no banco o usuário com email indicado em username
        Optional<Usuario> usuarioOptional= this.usuarioRepository.findByEmail(username);

        if(usuarioOptional.isEmpty()){
            throw new UsernameNotFoundException("Usuário não encontrado"); // não encontrou o usuário com email indicado em username
        }else{
            Usuario usuario = usuarioOptional.get();
            // dessa forma o spring security seja capaz de conhecer o nosso usuário
            return new UsuarioSecurity(usuario.getEmail(), usuario.getSenha(), usuario.getPerfil());
        }
    }
}
