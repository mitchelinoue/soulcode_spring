package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.FuncionarioDTO;
import org.soulcodeacademy.helpr.repositories.FuncionarioRepository;
import org.soulcodeacademy.helpr.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public List<Funcionario> listar(){

        return this.funcionarioService.listar();
    }

    @GetMapping("/funcionarios/{id}")
    public Funcionario getFuncionario(@PathVariable Integer id){

        return this.funcionarioService.getFuncionario(id);
    }

    @PostMapping("/funcionarios")
    public Funcionario salvar(@Valid @RequestBody FuncionarioDTO dto){

        Funcionario salvo = this.funcionarioService.salvar(dto);
        return salvo;
    }

    @PutMapping("/funcionarios/{idFuncionario}")
    public Funcionario atualizar(@PathVariable Integer idFuncionario, @Valid @RequestBody FuncionarioDTO dto){

        Funcionario funcionarioAtualizado = this.funcionarioService.atualizar(idFuncionario, dto);
        return funcionarioAtualizado;
    }

    @DeleteMapping("funcionarios/{idFuncionario}")
    public void deletar(@PathVariable Integer idFuncionario){
        this.funcionarioService.deletar(idFuncionario);
    }
}
