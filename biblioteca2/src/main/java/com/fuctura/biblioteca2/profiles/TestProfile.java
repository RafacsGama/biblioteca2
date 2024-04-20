package com.fuctura.biblioteca2.profiles;

import com.fuctura.biblioteca2.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("teste")
public class TestProfile {
    @Autowired
    private DBService database;

    @Bean
    public void instanciaDB(){
        this.database.instanciaDB();
    }
}
