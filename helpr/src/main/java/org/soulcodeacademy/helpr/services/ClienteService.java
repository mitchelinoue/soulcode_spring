package org.soulcodeacademy.helpr.services;


import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.ClienteDTO;
import org.soulcodeacademy.helpr.domain.dto.FuncionarioDTO;
import org.soulcodeacademy.helpr.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listar(){
        return this.clienteRepository.findAll();
    }

    public Cliente getCliente(Integer id){

        Optional<Cliente> cliente = this.clienteRepository.findById(id);

        if(cliente.isEmpty()){
            throw new RuntimeException("O cliente não foi encontrado");
        } else{
            return cliente.get();
        }
    }

    public Cliente salvar(ClienteDTO dto){
        Cliente cliente = new Cliente(null, dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getSenha(), dto.getTelefone());

        Cliente clienteSalvo = this.clienteRepository.save(cliente);
        return clienteSalvo;
    }

    public Cliente atualizar(Integer idCliente, ClienteDTO dto){

        Cliente clienteAtual = this.getCliente(idCliente);

        clienteAtual.setNome(dto.getNome());
        clienteAtual.setEmail(dto.getEmail());
        clienteAtual.setCpf(dto.getCpf());
        clienteAtual.setSenha(dto.getSenha());
        clienteAtual.setTelefone(dto.getTelefone());

        Cliente clienteAtualizado = this.clienteRepository.save(clienteAtual);
        return clienteAtualizado;
    }

    public void deletar(Integer idCliente){
        Cliente cliente = this.getCliente(idCliente);

        this.clienteRepository.delete(cliente);
    }


}
