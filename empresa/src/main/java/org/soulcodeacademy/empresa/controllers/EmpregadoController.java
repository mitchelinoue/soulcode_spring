package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.repositories.services.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmpregadoController {

    @Autowired
    private EmpregadoService empregadoService;

    @GetMapping("/empregados")
    public List<Empregado> listarCont(){ // listar todos
        return this.empregadoService.listarServ();
    }

    @GetMapping("/empregados/{idEmpregado}")
    public Empregado getEmpregadoCont(@PathVariable Integer idEmpregado){ // listar por id
        return this.empregadoService.listarEmpregadoIdServ(idEmpregado);
    }

    @PostMapping("/empregados")
    public Empregado salvarEmpregadoCont(@Valid @RequestBody EmpregadoDTO dto){
        return this.empregadoService.salvarEmpregadoServ(dto);
    }

    @PutMapping("/empregados/{idEmpregado}")
    public Empregado atualizarEmpregadoCont(@PathVariable Integer idEmpregado, @Valid @RequestBody EmpregadoDTO dto){
        return this.empregadoService.atualizarEmpregadoServ(idEmpregado, dto);
    }

    @DeleteMapping("/empregados/{idEmpregado}")
    public void deletarEmpregado(@PathVariable Integer idEmpregado){
        this.empregadoService.deletarEmpregado(idEmpregado);
    }


}
