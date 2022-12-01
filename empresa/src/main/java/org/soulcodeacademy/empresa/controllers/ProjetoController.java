package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.ProjetoDTO;
import org.soulcodeacademy.empresa.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping("/projetos")
    public List<Projeto> listarProjetosCont(){
        return this.projetoService.listarProjetosServ();
    }

    @GetMapping("/projetos/{idProjeto}")
    public Projeto listarProjetosIdCont(@PathVariable Integer idProjeto){
        return this.projetoService.listarProjetoIdServ(idProjeto);
    }

    @PostMapping("/projetos")
    public Projeto salvarProjetoCont(@Valid @RequestBody ProjetoDTO dto){
        return this.projetoService.salvarProjetoServ(dto);
    }

    @PutMapping("/projetos/{idProjeto}")
    public Projeto atualizarProjetoCont(@PathVariable Integer idProjeto, @Valid @RequestBody ProjetoDTO dto){
        return this.projetoService.atualizarProjetoServ(idProjeto, dto);
    }

    @DeleteMapping("/projetos/{idProjeto}")
    public void deletarProjetoCont(@PathVariable Integer idProjeto){
        this.projetoService.deletarProjetoServ(idProjeto);
    }


}
