package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;


    public Endereco getEnderecoServ(Integer idEndereco){ // listar por id
        Optional<Endereco> endereco = this.enderecoRepository.findById(idEndereco);

        if(endereco.isEmpty()){
            throw new RuntimeException("O endereço não foi encontrado");
        }else{
            return endereco.get();
        }
    }
}
