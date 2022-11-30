package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.dto.DependenteDTO;
import org.soulcodeacademy.empresa.services.DependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DependenteController {

    @Autowired
    private DependenteService dependenteService;

    @GetMapping("/dependentes")
    public List<Dependente> listarCont(){ // listar todos
        return this.dependenteService.listarServ();
    }

    @GetMapping("/dependentes/{idDependente}")
    public Dependente getDependente(@PathVariable Integer idDependente){ // listar por id
        return this.dependenteService.getDependenteServ(idDependente);
    }

    @PostMapping("/dependentes")
    public Dependente salvarCont(@Valid @RequestBody DependenteDTO dependente){ // criar novo
        Dependente salvo = this.dependenteService.salvarServ(dependente);
        return salvo;
    }




}
