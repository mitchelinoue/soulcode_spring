package org.soulcodeacademy.helpr.domain.dto;

import org.soulcodeacademy.helpr.controllers.CargoController;
import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Funcionario;

import javax.validation.constraints.NotNull;

public class FuncionarioDTO extends UsuarioDTO{
    private String foto;

    @NotNull(message = "cargo é obrigatório")
    private Integer IdCargo;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getIdCargo() { return IdCargo; }

    public void setIdCargo(Integer IdCargo) {
        this.IdCargo = IdCargo;
    }
}
