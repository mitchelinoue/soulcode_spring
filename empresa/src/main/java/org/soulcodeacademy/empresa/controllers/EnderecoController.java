package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;



    @GetMapping("/endereco")
    public Endereco getEnderecoCont(@PathVariable Integer idEndereco){ // listar por id
        return this.enderecoService.getEnderecoServ(idEndereco);
    }

}
