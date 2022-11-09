package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.dto.ClienteDTO;
import org.soulcodeacademy.helpr.repositories.ClienteRepository;
import org.soulcodeacademy.helpr.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        return this.clienteService.listar();
    }

    @GetMapping("/clientes/{id}")
    public Cliente getCliente(@PathVariable Integer id){
        return this.clienteService.getCliente(id);
    }

    @PostMapping("/clientes")
    public Cliente salvar(@Valid @RequestBody ClienteDTO dto){

        Cliente clienteAtualizado = this.clienteService.salvar(dto);
        return clienteAtualizado;
    }

    @PutMapping("/clientes/{idCliente}")
    public Cliente atualizar(@PathVariable Integer idCliente, @Valid @RequestBody ClienteDTO dto){

        Cliente clienteAtualizado = this.clienteService.atualizar(idCliente, dto);
        return clienteAtualizado;
    }

    @DeleteMapping("clientes/{idCliente}")
    public void deletar(@PathVariable Integer idCliente){
        this.clienteService.deletar(idCliente);
    }


}
