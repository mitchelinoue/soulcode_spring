package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.repositories.DependenteRepository;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.soulcodeacademy.empresa.repositories.EnderecoRepository;
import org.soulcodeacademy.empresa.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TesteService {

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @PostConstruct
    public void testarEntidades(){
        Empregado empregado1 = new Empregado(null, "José Carlos", "jc@gmail.com", 7000.0);
        Empregado empregado2 = new Empregado(null, "José Antonio", "ja@gmail.com", 8500.0);
        Empregado empregado3 = new Empregado(null, "Cláudio José", "cj@gmail.com", 8500.0);

        Endereco endereco1 = new Endereco (null, "Ubajara", "CE");
        Endereco endereco2 = new Endereco(null, "São Paulo", "SP");
        Endereco endereco3 = new Endereco(null, "São Paulo", "SP");

        // associação 1:1
        empregado1.setEndereço(endereco1);
        empregado2.setEndereço(endereco2);
        empregado3.setEndereço(endereco3);

        this.enderecoRepository.saveAll(List.of(endereco1, endereco2, endereco3));
        this.empregadoRepository.saveAll(List.of(empregado1, empregado2, empregado3));

        Dependente dependente1 = new Dependente(null, "Maria Antonieta", 13);
        Dependente dependente2 = new Dependente(null, "Carlos José", 11);
        Dependente dependente3 = new Dependente(null, "Pedro Alves", 9);

        // associação 1:N
        dependente1.setResponsavel(empregado1);
        dependente2.setResponsavel(empregado2);
        dependente3.setResponsavel(empregado1);

        this.dependenteRepository.saveAll(List.of(dependente1, dependente2, dependente3));

        // associação N:N
        Projeto projeto1 = new Projeto(null, "Campanha de marketing I", 5000.0, "Campanha 1º semestre");
        Projeto projeto2 = new Projeto(null, "Campanha de marketing II", 8500.0, "Campanha 2º semestre");

        this.projetoRepository.saveAll(List.of(projeto1,projeto2));

        empregado1.getProjetos().add(projeto1); // o empregado1 participa do projeto1
        empregado1.getProjetos().add(projeto2); // o empregado1 participa do projeto2
        empregado2.getProjetos().add(projeto2); // o empregado2 participa do projeto2

        this.empregadoRepository.save(empregado1);
        this.empregadoRepository.save(empregado2);

        // remover projeto do empregado
        Empregado preguicoso = this.empregadoRepository.findById(2).orElseThrow();
        System.out.println(preguicoso.getProjetos());
        preguicoso.getProjetos().remove(projeto2);

        this.empregadoRepository.save(preguicoso);



      /*  // igualdade de objetos
        // quando usamos new, alocamos o objeto em um endereço de memória, então eles não são iguais
        Projeto projeto1 = new Projeto(1, "Campanha I", 2500.0, "Descrição top");
        Projeto projeto2= new Projeto(1, "Campanha I", 2500.0, "Descrição top");

        if (projeto1.equals(projeto2)) {
            System.out.println("São iguais");

        }else {
            System.out.println("nao são");
        }
        System.out.println(projeto1.hashCode());
        System.out.println(projeto2.hashCode());*/

    }
}
