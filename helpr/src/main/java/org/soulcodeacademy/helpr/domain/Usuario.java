package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.Perfil;

import javax.persistence.*;

@Entity
@Table(name = "Usuários") // coloca o nome específico na tabela, e não o nome da classe
public abstract class Usuario { // abstract não deixa criar objetos dessa class, já que essa é uma classe pai. Usuário será funcionário ou cliente

    @Id // torna o campo abaixo em uma primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // preenche o campo id com auto_increment
    protected Integer id;

    @Column(nullable = false, length = 150)
    protected String nome;

    @Column(nullable = false, unique = true, length = 120)
    protected String email;

    @Column(nullable = false, unique = true, length = 11)
    protected String cpf;

    @Column(nullable = false)
    protected String senha;

    @Enumerated(EnumType.STRING) // representa os valores do enum como texto
    @Column(nullable = false)
    protected Perfil perfil; // indica o que este usuário é no sistema

    public Usuario(){

    }

    public Usuario(Integer id, String nome, String email, String cpf, String senha, Perfil perfil){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.perfil = perfil;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
