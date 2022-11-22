package org.soulcodeacademy.helpr.repositories;

import org.apache.tomcat.util.modeler.OperationInfo;
import org.soulcodeacademy.helpr.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email); // WHERE email = email

    Optional<Usuario> findByCpf(String cpf); // WHERE cpf = cpf

    List<Usuario> findByNomeContaining(String nome); // filtrar pelo nome


    // um resultado = OPTIONAL
    // vários = LIST
    // Seguindo a convenção findBy o Spring implementa o método derivado/customizado
}



// Métodos presentes:
// - FindAll => SELECT * FROM usuarios
// - findById => SELECT * FROM usuarios id = ?
// - save => INSERT INTO (caso id nulo) ou UPDATE (caso id ñ nulo)
// - delete => DELETE FROM usuarios WHERE id = ?

// CRUD de funcionarios
// Entidade -> Repository -> DTO -> Service + Controller