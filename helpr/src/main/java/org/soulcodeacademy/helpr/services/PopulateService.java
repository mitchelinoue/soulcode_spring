package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.soulcodeacademy.helpr.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // indica para o spring que essa classe será gerenciada por ele
public class PopulateService {
    @Autowired // injetar o objeto direto na classe
    private CargoRepository cargoRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void populate(){
        // Integer idCargo, String nome, String descricao, Double salario
        Cargo c1 = new Cargo(null, "Diretor geral", "Gerenciar a empresa", 30000.0);
        Cargo c2 = new Cargo(null, "Diretor de setor", "Gerencia um setor da empresa", 18000.0);
        Cargo c3 = new Cargo(null, "Técnico Geral", "Resolve os chamados urgentes", 12000.0);

        //Integer id, String nome, String email, String cpf, String senha, String foto, Cargo cargo
        Funcionario f1 = new Funcionario(null, "Renato Pereira", "renato.pereira@email.com", "12345678910", "senha@123", "foto.jpg", 1);
        Funcionario f2 = new Funcionario(null, "Victor Icoma", "victor.icoma@email.com", "45678912388", "s!456", "foto.jpg", 2);
        Funcionario f3 = new Funcionario(null, "Lucas Oliveira", "lucas.oliveira@email.com", "78945612352", "ha#333", "foto.jpg", 3);

        // vamos persistir as entidades = salvar no banco
        this.cargoRepository.save(c1); // insert into
        this.cargoRepository.save(c2);
        this.cargoRepository.save(c3);

        this.funcionarioRepository.save(f1);
        this.funcionarioRepository.save(f2);
        this.funcionarioRepository.save(f3);
    }
}

// o objetivo dessa classe é inserir no banco dados fictícios (de teste)
// IOC = inversion of Control = Inversão de controle = É ele quem manda nas instâncias
// Container = é o local onde o spring guarda os objetos anotados
// @Service indica que a classe é um serviço
// injeção de dependencias = quando o Spring injeta os objetos na classe