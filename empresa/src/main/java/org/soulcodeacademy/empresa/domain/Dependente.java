package org.soulcodeacademy.empresa.domain;

import javax.persistence.*;

@Entity
public class Dependente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdDependente;

    @Column(nullable = false, length = 120)
    private String nome;

    @Column(nullable = false)
    private Integer idade;

    @ManyToOne
    @JoinColumn(name = "id_Responsavel", nullable = false)
    public Empregado responsavel;

    public Dependente(){}

    public Dependente(Integer idDependente, String nome, Integer idade) {
        IdDependente = idDependente;
        this.nome = nome;
        this.idade = idade;
    }

    public Integer getIdDependente() {
        return IdDependente;
    }

    public void setIdDependente(Integer idDependente) {
        IdDependente = idDependente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Empregado getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Empregado responsavel) {
        this.responsavel = responsavel;
    }

}
