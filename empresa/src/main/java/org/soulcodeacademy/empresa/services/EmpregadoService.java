package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoService {

    @Autowired
    EmpregadoRepository empregadoRepository;

    @Autowired
    EnderecoService enderecoService;

    public List<Empregado> listarServ(){
        return this.empregadoRepository.findAll();
    }


    public Empregado getEmpregadoServ(Integer idEmpregado){ // listar por id
        Optional<Empregado> empregado = this.empregadoRepository.findById(idEmpregado);

        if(empregado.isEmpty()){
            throw new RuntimeException("O empregado não foi encontrado");
        }else{
            return empregado.get();
        }
    }

    public Empregado salvarServ(EmpregadoDTO dto){

        Endereco endereco = this.enderecoService.getEnderecoServ(dto.getIdEndereço());

        Empregado empregado = new Empregado(null, dto.getNome(), dto.getEmail(), dto.getSalario());

        return this.empregadoRepository.save(empregado);
    }


}
