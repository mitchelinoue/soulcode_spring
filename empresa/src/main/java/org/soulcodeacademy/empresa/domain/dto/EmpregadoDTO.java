package org.soulcodeacademy.empresa.domain.dto;

import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.Projeto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class EmpregadoDTO {

    @NotBlank(message = "Nome do empregado é obrigatório")
    private String nome;

    @NotBlank(message = "E-mail do empregado é obrigatório")
    private String email;

    @NotNull(message = "Campo salário é obrigatório")
    @Min(value = 500, message = "Campo salário inválido")
    @Max(value = 100000, message = "Campo salário inválido")
    private Double salario;

    @NotNull(message = "idEndereço é obrigatorio")
    private Integer idEndereco;

    private List<Integer> idProjetos;

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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public List<Integer> getIdProjetos() {
        return idProjetos;
    }

    public void setIdProjetos(List<Integer> idProjetos) {
        this.idProjetos = idProjetos;
    }
}
