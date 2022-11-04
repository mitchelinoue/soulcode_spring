package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    // listar todos
    public List<Cargo> listar(){
        // retorna os dados da tabela em forma de lista (SELECT * FROM cargo)
        return this.cargoRepository.findAll();
    }
    // Listar um pelo ID
    public Cargo getCargo(Integer idCargo){
        //SELECT * FROM cargo WHERE idCargo = ?
        // Optional = Pode haver cargo ou não
        Optional<Cargo> cargo = this.cargoRepository.findById(idCargo);

        if(cargo.isEmpty()){
            // não encontrou o cargo com id solicitado
            throw new RuntimeException("O cargo não foi encontrado"); // Causa erro com a mensagem
        } else {
            return cargo.get(); // Extrair o cargo de dentro do optional
        }
    }
    // Salvar
    public Cargo salvar(Cargo novoCargo){
        novoCargo.setIdCargo(null); // limpar o campo id para não substituir

        //ISERT INTO cargo
        Cargo cargoSalvo = this.cargoRepository.save(novoCargo);
        return cargoSalvo;
    }


    // Atualizar
    // Deletar
}
