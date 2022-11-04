package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.soulcodeacademy.helpr.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // retorno de dados
public class CargoController {

    // endpoint é o endereço que será acessado no backend
    @GetMapping("/oi") // com base em localhost:8080/oi retorna a String
    public String dizOla(){
        return "Hello, world!"; // resposta da requisição
    }

    @GetMapping("/batata")
    public Integer valor(){
        return 1000; // resposta da requisição
    }

    @Autowired
    private CargoService cargoService;

    @GetMapping("/cargos")
    public List<Cargo> listar(){

        // requisição -> controller -> service -> repository -> SELECT * FROM Cargo
        return this.cargoService.listar(); // JSON javascript object notation

    }

    @GetMapping("/cargos/{idCargo}") // indica que o valor após a barra é dinâmico
    public Cargo getCargo(@PathVariable Integer idCargo){ // @PathVariable -> extrai do endpoint o valor dinâmico

        return this.cargoService.getCargo(idCargo);

    }

    // podemos usar o mesmo endpoint para verbos diferentes
    @PostMapping("/cargos") // requisição tipo post para /cargos
    public Cargo salvar(@RequestBody Cargo cargo){ // @RequestBody - extrair o JSON do corpo e converte para cargo (deserialização)
        Cargo salvo = this.cargoService.salvar(cargo);
        return salvo; // a resposta será o cargo inserido
    }

    // mapeia requisições do verbo PUT
    @PutMapping("/cargos/{idCargo}") // ex: /cargo/5
    public Cargo atualizar(@PathVariable Integer idCargo, @RequestBody Cargo cargo){

        Cargo atualizado = this.cargoService.atualizar(idCargo, cargo);
        return atualizado;
    }

    @DeleteMapping("/cargos/{idCargo}") // verbo DELETE no /cargo/2 (ex.)
    public void deletar(@PathVariable Integer idCargo){
        this.cargoService.deletar(idCargo);

    }

}
