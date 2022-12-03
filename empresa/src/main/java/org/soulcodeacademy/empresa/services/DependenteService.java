package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.dto.DependenteDTO;
import org.soulcodeacademy.empresa.repositories.DependenteRepository;
import org.soulcodeacademy.empresa.services.errors.RecursoNaoEncontradoError;
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

    public List<Dependente> listarDependentesServ(){ // listar todos
        return this.dependenteRepository.findAll();
    }

    public Dependente listarDependenteIdServ(Integer idDependente){ //listar por id
        Optional<Dependente> dependente = this.dependenteRepository.findById(idDependente);

        if(dependente.isEmpty()){
            throw new RecursoNaoEncontradoError("O dependente não foi encontrado");
        } else {
            return dependente.get();
        }
    }

    public Dependente salvarDependenteServ(DependenteDTO dto){ // criar novo
        Empregado empregado = this.empregadoService.listarEmpregadoIdServ(dto.getIdResponsavel());

        Dependente dependente = new Dependente(null, dto.getNome(), dto.getIdade());

        dependente.setResponsavel(empregado);

        Dependente dependenteSalvo = this.dependenteRepository.save(dependente);
        return dependenteSalvo;
    }

    public Dependente atualizarDependenteServ(Integer idDependente, DependenteDTO dto){
        Dependente dependente = this.listarDependenteIdServ(idDependente);
        Empregado empregado = this.empregadoService.listarEmpregadoIdServ(dto.getIdResponsavel());

        dependente.setNome(dto.getNome());
        dependente.setIdade(dto.getIdade());
        dependente.setResponsavel(empregado);

        return this.dependenteRepository.save(dependente);

    }

    public void deletarDependenteServ(Integer idDependente){
        Dependente dependente = this.listarDependenteIdServ(idDependente);

        this.dependenteRepository.delete(dependente);
    }






}
