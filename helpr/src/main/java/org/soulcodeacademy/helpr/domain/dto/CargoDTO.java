package org.soulcodeacademy.helpr.domain.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//DTO -> objeto de transferência de dados
// É útil para validarmos as informações transferidas pelo cliente
public class CargoDTO {

    // notblank impede que um campo de string seja string vazia "", message é o texto da validação
    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;

    @NotBlank(message = "Campo descrição é obrigatório")
    private String descricao;

    // notnull impede que o valor seja null
    @NotNull(message = "Campo salário é obrigatório")
    @Min(value = 500, message = "Campo salário inválido")
    @Max(value = 100000, message = "Campo salário inválido")
    private Double salario;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
