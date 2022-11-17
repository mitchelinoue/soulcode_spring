package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // indica que a interface é um repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> { // <entidade, pk>
    List<Cargo> findByNome(String nome); //WHERE nome = valor

    List<Cargo> findBySalario(Double valor); //WHERE salario = valor

    List<Cargo> findBySalarioGreaterThan(Double valor); //Where salario > valor

    List<Cargo> findBySalarioGreaterThanEqual(Double valor); // WHERE salario >= valor

    List<Cargo> findBySalarioLessThan(Double valor); // WHERE salario < valor

    List<Cargo> findBySalarioLessThanEqual(Double valor); // WHERE salario <= valor

    List<Cargo> findBySalarioBetween(Double valor1, Double valor2); // encontra entre os valores
}

// repository = recurso que permite manipular a entidade no banco de dados
// adicionar entidades, atualizar entidades, remover entidades e listar (CRUD)
// indicar qual a entidade que vai ser gerenciada pelo repository e qual o tipo da pk
// Obs: O spring gera uma classe dinâmica com base em nossa interface CargoRepository
// CrudRepository vêm do spring e contém as operações básicas de um banco de dados
// Jparepository = possui mais funcionalidades p/ tratar a entidade