package org.soulcodeacademy.empresa.repositories.services;

import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.ProjetoDTO;
import org.soulcodeacademy.empresa.repositories.ProjetoRepository;
import org.soulcodeacademy.empresa.repositories.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> listarProjetosServ(){
        return this.projetoRepository.findAll();
    }

    public Projeto listarProjetoIdServ(Integer idProjeto){
        Optional<Projeto> projeto = this.projetoRepository.findById(idProjeto);

        if(projeto.isEmpty()){
            throw new RecursoNaoEncontradoError("Projeto não encontrado");
        }else{
            return projeto.get();
        }
    }

    public Projeto salvarProjetoServ(ProjetoDTO dto){
        Projeto projeto = new Projeto(null, dto.getNome(), dto.getOrcamento(), dto.getDescricao());

        return this.projetoRepository.save(projeto);
    }

    public Projeto atualizarProjetoServ(Integer idProjeto, ProjetoDTO dto){
        Projeto projeto = this.listarProjetoIdServ(idProjeto);

        projeto.setNome(dto.getNome());
        projeto.setOrcamento(dto.getOrcamento());
        projeto.setDescricao(dto.getDescricao());

        return this.projetoRepository.save(projeto);
    }

    public void deletarProjetoServ(Integer idProjeto){
        Projeto projeto = this.listarProjetoIdServ(idProjeto);

        this.projetoRepository.delete(projeto);
    }



}
