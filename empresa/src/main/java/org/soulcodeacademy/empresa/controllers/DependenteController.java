package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.dto.DependenteDTO;
import org.soulcodeacademy.empresa.services.DependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.Inet4Address;
import java.util.List;

@RestController
public class DependenteController {

    @Autowired
    private DependenteService dependenteService;

    @GetMapping("/dependentes")
    public List<Dependente> listarDependentesCont(){ // listar todos
        return this.dependenteService.listarDependentesServ();
    }

    @GetMapping("/dependentes/{idDependente}")
    public Dependente listarDependenteIdCont(@PathVariable Integer idDependente){ // listar por id
        return this.dependenteService.listarDependenteIdServ(idDependente);
    }

    @PostMapping("/dependentes")
    public Dependente salvarCont(@Valid @RequestBody DependenteDTO dependente){ // criar novo
        return this.dependenteService.salvarDependenteServ(dependente);
    }

    @PutMapping("/dependentes/{idDependente}")
    public Dependente atualizarDependenteCont(@PathVariable Integer idDependente, @Valid @RequestBody DependenteDTO dto){
        return this.dependenteService.atualizarDependenteServ(idDependente, dto);
    }

    @DeleteMapping("/dependentes/{idDependente}")
    public void deletarDependenteCont(@PathVariable Integer idDependente){
        this.dependenteService.deletarDependenteServ(idDependente);
    }




}
