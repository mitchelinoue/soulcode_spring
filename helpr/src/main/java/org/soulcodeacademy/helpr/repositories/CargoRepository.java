package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // indica que a interface é um repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> { // <entidade, pk>
}

// repository = recurso que permite manipular a entidade no banco de dados
// adicionar entidades, atualizar entidades, remover entidades e listar (CRUD)
// indicar qual a entidade que vai ser gerenciada pelo repository e qual o tipo da pk
// Obs: O spring gera uma classe dinâmica com base em nossa interface CargoRepository
// CrudRepository vêm do spring e contém as operações básicas de um banco de dados
// Jparepository = possui mais funcionalidades p/ tratar a entidade