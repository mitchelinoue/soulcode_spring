package org.soulcodeacademy.helpr.config;

import org.soulcodeacademy.helpr.services.PopulateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

// Indica que essa classe será gerenciada pelo Spring e que ela é uma classe de configuração
@Configuration
@Profile("dev") // será intanciada apenas se o perfil ativo for "dev"
public class DevConfig {
    // Esta classe irá chamar o PopulateService caso o perfil ativo seja de desenvolvimento
    @Autowired // injeta o service na classe config
    private PopulateService populateService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;


    // Após construir o DevConfig, insere o método abaixo
    @PostConstruct // faz com que o método execute após a instância ser criada
    public void init(){
        System.out.println("Batata!!!");
        // se o modo for create, insere os dados fictícios
        if(this.ddlAuto.equals("create")){
            this.populateService.populate();
        }
    }
}
