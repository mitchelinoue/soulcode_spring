package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.dto.DependenteDTO;
import org.soulcodeacademy.empresa.repositories.DependenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DependenteService {

    @Autowired
    DependenteRepository dependenteRepository;

    @Autowired
    EmpregadoService empregadoService;

    public List<Dependente> listarServ(){ // listar todos
        return this.dependenteRepository.findAll();
    }

    public Dependente getDependenteServ(Integer idDependente){ //listar por id
        Optional<Dependente> dependente = this.dependenteRepository.findById(idDependente);

        if(dependente.isEmpty()){
            throw new RuntimeException("O cargo não foi encontrado");
        } else {
            return dependente.get();
        }
    }

    public Dependente salvarServ(DependenteDTO dto){ // criar novo
        Empregado empregado = this.empregadoService.getEmpregadoServ(dto.getIdResponsavel());

        Dependente dependente = new Dependente(null, dto.getNome(), dto.getIdade());

        dependente.setResponsavel(empregado);

        Dependente dependenteSalvo = this.dependenteRepository.save(dependente);
        return dependenteSalvo;
    }






}
