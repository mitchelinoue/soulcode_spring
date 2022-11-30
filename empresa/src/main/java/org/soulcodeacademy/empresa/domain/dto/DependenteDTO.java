package org.soulcodeacademy.empresa.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DependenteDTO {

    @NotBlank(message = "nome do dependente é obrigatório")
    private String nome;

    @NotNull(message = "idade é obrigatório")
    private Integer idade;

    @NotNull(message = "idResponsavel é obrigatório")
    private Integer idResponsavel;

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

    public Integer getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Integer idResponsavel) {
        this.idResponsavel = idResponsavel;
    }
}
