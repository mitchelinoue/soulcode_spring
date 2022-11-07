package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}


// Métdos presentes:
// - FindAll => SELECT * FROM usuarios
// - findById => SELECT * FROM usuarios id = ?
// - save => INSERT INTO (caso id nulo) ou UPDATE (caso id ñ nulo)
// - delete => DELETE FROM usuarios WHERE id = ?

// CRUD de funcionarios
// Entidade -> Repository -> DTO -> Service + Controller