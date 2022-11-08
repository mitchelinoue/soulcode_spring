package org.soulcodeacademy.helpr.domain.dto;

import org.soulcodeacademy.helpr.controllers.CargoController;
import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Funcionario;

import javax.validation.constraints.NotNull;

public class FuncionarioDTO extends UsuarioDTO{
    private String foto;

    @NotNull(message = "idCargo é obrigatório")
    private Integer idCargo;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }
}
