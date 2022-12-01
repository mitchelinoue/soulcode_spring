package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.EnderecoDTO;
import org.soulcodeacademy.empresa.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping("/enderecos")
    public List<Endereco> listarEnderecoCont(){
        return this.enderecoService.listarEnderecoServ();
    }

    @GetMapping("/enderecos/{idEndereco}")
    public Endereco getEnderecoCont(@PathVariable Integer idEndereco){ // listar por id
        return this.enderecoService.getEnderecoServ(idEndereco);
    }

    @PostMapping("/enderecos")
    public Endereco salvarEnderecoCont(@Valid @RequestBody EnderecoDTO dto){
        return this.enderecoService.salvarEnderecoServ(dto);
    }

    @PutMapping("/enderecos/{idEndereco}")
    public Endereco atualizarEnderecoCont(@PathVariable Integer idEndereco, @Valid @RequestBody EnderecoDTO dto){
        return this.enderecoService.atualizarEnderecoServ(idEndereco, dto);
    }

    @DeleteMapping("/enderecos/{idEndereco}")
    public void deletarEnderecoCont(@PathVariable Integer idEndereco){
        this.enderecoService.deletarEnderecoServ(idEndereco);
    }

}
