package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.FuncionarioDTO;
import org.soulcodeacademy.helpr.repositories.FuncionarioRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CargoService cargoService;

    public List<Funcionario> listar(){
        return this.funcionarioRepository.findAll();
    }

    public List<Funcionario> listarPorFaixaSalarial(Double valor1, Double valor2){
        return this.funcionarioRepository.findBySalarioEntreFaixas(valor1, valor2);
    }

    public Funcionario getFuncionario(Integer id){

        Optional<Funcionario> funcionario = this.funcionarioRepository.findById(id);

        if(funcionario.isEmpty()){
            throw new RecursoNaoEncontradoError("O funcionário não foi encontrado");
        }else{
            return funcionario.get();
        }
    }

    public Funcionario salvar(FuncionarioDTO dto) {

        //verifica se o cargo existe mesmo
        Cargo cargo = this.cargoService.getCargo(dto.getIdCargo());

        Funcionario funcionario = new Funcionario(null, dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getSenha(), dto.getFoto(), cargo);

        Funcionario funcionarioSalvo = this.funcionarioRepository.save(funcionario);
        return funcionarioSalvo;

    }

    public Funcionario atualizar(Integer idFuncionario, FuncionarioDTO dto){

        //busca o funcionário com o idFuncionario
        Funcionario funcionarioAtual = this.getFuncionario(idFuncionario);

        //busca os dados do cargo a ser alterado
        Cargo cargo = this.cargoService.getCargo(dto.getIdCargo());

        funcionarioAtual.setNome(dto.getNome());
        funcionarioAtual.setEmail(dto.getEmail());
        funcionarioAtual.setCpf(dto.getCpf());
        funcionarioAtual.setSenha(dto.getSenha());
        funcionarioAtual.setFoto(dto.getFoto());
        funcionarioAtual.setCargo(cargo);

        Funcionario FuncionarioAtualizado = this.funcionarioRepository.save(funcionarioAtual);
        return FuncionarioAtualizado;
    }

    public void deletar(Integer idFuncionario){
        Funcionario funcionario = this.getFuncionario(idFuncionario);

        this.funcionarioRepository.delete(funcionario);
    }

}
