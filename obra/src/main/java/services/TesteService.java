package services;

import domain.Engenheiro;
import domain.Obra;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.*;

import javax.annotation.PostConstruct;

public class TesteService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private EngenheiroRepository engenheiroRepository;

    @Autowired
    private FerramentaRepository ferramentaRepository;

    @Autowired
    private ObraRepository obraRepository;

    @Autowired
    private SetorRepository setorRepository;

    @PostConstruct
    public void testarEntidades(){

        Obra obra1 = new Obra(null, "SoulCode", 1500000);
        this.obraRepository.save(obra1);

        Engenheiro eng1 = new Engenheiro(null, "Mitchel", 32, "mitchel@email.com", 10000);
        this.engenheiroRepository.save(eng1);













    }





}
