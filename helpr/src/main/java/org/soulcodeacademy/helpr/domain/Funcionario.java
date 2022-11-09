package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.soulcodeacademy.helpr.repositories.CargoRepository;

import javax.persistence.*;

@Entity
public class Funcionario extends Usuario { //Gera uma coluna dtype para indicar qual a subclasse

    private String foto; // coluna foto não é obrigatória

    @ManyToOne// Muitos funcionários para um cargo
    @JoinColumn(name = "idCargo") // Cria uma coluna nova que é a chave estrangeira de cargo
    private Cargo cargo; // se eu quiser mudar o cargo do funcionario, basta eu mudar o objeto deste campo

    public Funcionario() {}

    public Funcionario(Integer id, String nome, String email, String cpf, String senha, String foto, Cargo cargo) {
        super(id, nome, email, cpf, senha, Perfil.FUNCIONARIO); // Chamada do construtor de Usuario
        this.foto = foto;
        this.cargo = cargo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}

// Anotações de relacionamento
// @OneToOne = 1:1
// @OneToMany / @ManyToOne = 1:N
// @ManyToMany = N:N

// Relacionamento unidirecional = apenas uma das entidades "conhece" a outra
// Relacionamento bidirecional = ambas entidades se "conhecem"



//===BIDIRECIONAL=======================
//
//   CLASSE EMPREGADO
//   List<Dependente> dependentes;
//
//
//   CLASSE DEPENDENTE
//   private Empregado empregado;
//
//===UNIDIRECIONAL=======================
//
//   CLASSE CARGO
//   <nenhum>
//
//   CLASSE FUNCIONARIO
//   private Cargo cargo;