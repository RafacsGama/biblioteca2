package com.fuctura.biblioteca2.profiles;

import com.fuctura.biblioteca2.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevProfile {
    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;
    //atribuindo a variável ddl o valor do spring.jpa.hibernate.ddl-auto

    @Bean
    public boolean instanciaDB(){
        if(ddl.equals("create-drop")){
            this.dbService.instanciaDB();
        }
        return false;
    }
}