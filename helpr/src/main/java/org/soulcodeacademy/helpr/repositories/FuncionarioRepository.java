package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    List<Funcionario> findByCargo(Cargo cargo); // Filtrar os funcionários que possuem tal cargo
    List<Funcionario> findByFotoIsNull(); // Filtrar os funcionário sem foto definida
    List<Funcionario> findByFotoIsNotNull(); // Filtrar os funcionário com foto definida

    @Query(value = "SELECT * FROM usuários INNER JOIN cargo ON usuários.id_cargo = cargo.id_cargo WHERE dtype = 'Funcionario' AND cargo.salario BETWEEN :valor1 AND :valor2", nativeQuery = true)
    List<Funcionario> findBySalarioEntreFaixas(Double valor1, Double valor2);
}
