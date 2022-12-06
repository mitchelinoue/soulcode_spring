package org.soulcodeacademy.empresa.repositories.services;

import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.EnderecoDTO;
import org.soulcodeacademy.empresa.repositories.EnderecoRepository;
import org.soulcodeacademy.empresa.repositories.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listarEnderecoServ(){
        return this.enderecoRepository.findAll();
    }

    public Endereco getEnderecoServ(Integer idEndereco){ // listar por id
        Optional<Endereco> endereco = this.enderecoRepository.findById(idEndereco);

        if(endereco.isEmpty()){
            throw new RecursoNaoEncontradoError("O endereço não foi encontrado");
        }else{
            return endereco.get();
        }
    }

    public Endereco salvarEnderecoServ(EnderecoDTO dto){
        Endereco endereco = new Endereco(null,dto.getCidade(), dto.getUf());
        return this.enderecoRepository.save(endereco);
    }

    public Endereco atualizarEnderecoServ( Integer idEndereco, EnderecoDTO dto){
        Endereco enderecoAtual = this.getEnderecoServ(idEndereco);

        enderecoAtual.setCidade(dto.getCidade());
        enderecoAtual.setUf(dto.getUf());

        return this.enderecoRepository.save(enderecoAtual);

    }

    public void deletarEnderecoServ(Integer idEndereco){
        Endereco endereco = this.getEnderecoServ(idEndereco);

        this.enderecoRepository.delete(endereco);
    }
}
