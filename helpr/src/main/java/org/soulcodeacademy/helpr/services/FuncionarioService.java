package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.FuncionarioDTO;
import org.soulcodeacademy.helpr.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listar(){
        return this.funcionarioRepository.findAll();
    }

    public Funcionario getFuncionario(Integer id){

        Optional<Funcionario> funcionario = this.funcionarioRepository.findById(id);

        if(funcionario.isEmpty()){
            throw new RuntimeException("O funcionário não foi encontrado");
        }else{
            return funcionario.get();
        }
    }

    public Funcionario salvar(FuncionarioDTO dto) {

        Funcionario funcionario = new Funcionario(null, dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getSenha(), dto.getFoto(), dto.getIdCargo());

        Funcionario funcionarioSalvo = this.funcionarioRepository.save(funcionario);
        return funcionarioSalvo;

    }

}
