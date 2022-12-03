package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.soulcodeacademy.empresa.repositories.EnderecoRepository;
import org.soulcodeacademy.empresa.services.errors.ParametrosInvalidosError;
import org.soulcodeacademy.empresa.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoService {

    @Autowired
    EmpregadoRepository empregadoRepository;

    @Autowired
    EnderecoService enderecoService;

    @Autowired
    ProjetoService projetoService;

    public List<Empregado> listarServ(){
        return this.empregadoRepository.findAll();
    }


    public Empregado listarEmpregadoIdServ(Integer idEmpregado){ // listar por id
        Optional<Empregado> empregado = this.empregadoRepository.findById(idEmpregado);

        if(empregado.isEmpty()){
            throw new RecursoNaoEncontradoError("O empregado não foi encontrado");
        }else{
            return empregado.get();
        }
    }

    public Empregado salvarEmpregadoServ(EmpregadoDTO dto){

        Endereco endereco = this.enderecoService.getEnderecoServ(dto.getIdEndereco());

        Empregado empregado = new Empregado(null, dto.getNome(), dto.getEmail(), dto.getSalario());

        for(Empregado emp : this.listarServ()){
            if(emp.getEndereco() != endereco){
                empregado.setEndereco(endereco);
            }else{
                throw new ParametrosInvalidosError("Endereço em utilização");
            }
        }

        return this.empregadoRepository.save(empregado);
    }

    public Empregado atualizarEmpregadoServ(Integer idEmpregado, EmpregadoDTO dto){
        Empregado empregado = this.listarEmpregadoIdServ(idEmpregado);
        Endereco endereco = this.enderecoService.getEnderecoServ(dto.getIdEndereco());

        List<Projeto> projetos = new ArrayList<>();

        for(Integer idProjeto : dto.getIdProjetos()){
            Projeto projeto = this.projetoService.listarProjetoIdServ(idProjeto);
            projetos.add(projeto);
            }

        empregado.setNome(dto.getNome());
        empregado.setEmail(dto.getEmail());
        empregado.setSalario(dto.getSalario());
        empregado.setEndereco(endereco);
        empregado.setProjetos(projetos);

        return this.empregadoRepository.save(empregado);

        }

    public void deletarEmpregado(Integer idEmpregado){
        Empregado empregado = this.listarEmpregadoIdServ(idEmpregado);
        this.empregadoRepository.delete(empregado);

    }

}



