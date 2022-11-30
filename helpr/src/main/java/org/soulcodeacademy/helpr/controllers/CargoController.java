package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.dto.CargoDTO;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.soulcodeacademy.helpr.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_FUNCIONARIO')") //somente funcionario e admin podem acessar
    @GetMapping("/cargos")
    public List<Cargo> listar(){
        // requisição -> controller -> service -> repository -> SELECT * FROM Cargo
        return this.cargoService.listar(); // JSON javascript object notation
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_FUNCIONARIO')") //somente funcionario e admin podem acessar
    @GetMapping("/cargos/{idCargo}") // indica que o valor após a barra é dinâmico
    public Cargo getCargo(@PathVariable Integer idCargo){ // @PathVariable -> extrai do endpoint o valor dinâmico

        return this.cargoService.getCargo(idCargo);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")  // somente admin pode criar cargos
    @PostMapping("/cargos") // requisição tipo post para /cargos e podemos usar o mesmo endpoint para verbos diferentes
    public Cargo salvar(@Valid @RequestBody CargoDTO cargo){ // @RequestBody - extrair o JSON do corpo e converte para cargo (deserialização)
        Cargo salvo = this.cargoService.salvar(cargo);
        return salvo; // a resposta será o cargo inserido
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")  // somente admin pode atualizar cargos
    @PutMapping("/cargos/{idCargo}") // ex: /cargo/5 - mapeia requisições do verbo PUT
    public Cargo atualizar(@PathVariable Integer idCargo, @Valid @RequestBody CargoDTO dto){

        Cargo atualizado = this.cargoService.atualizar(idCargo, dto);
        return atualizado;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")  // somente admin pode deletar cargos
    @DeleteMapping("/cargos/{idCargo}") // verbo DELETE no /cargo/2 (ex.)
    public void deletar(@PathVariable Integer idCargo){
        this.cargoService.deletar(idCargo);
    }

}
