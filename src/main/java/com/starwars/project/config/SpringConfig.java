package com.starwars.project.config;

import com.starwars.project.model.dto.FilmDTO;
import com.starwars.project.model.entity.Film;
import com.starwars.project.model.entity.People;
import com.starwars.project.model.entity.Planet;
import com.starwars.project.util.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;

@Configuration
public class SpringConfig {

    @Bean
    public WebClient.Builder getWebClientBuilder(){
        return WebClient.builder();
    }

    @Bean
    FilmDTO filmDTO(){
        return new FilmDTO();
    }

    @Bean
    HashMap<String,Class<?>> entityClasses(){
        HashMap<String, Class<?>> entities=new HashMap<>();
        entities.put(Constants.FILMS, Film.class);
        entities.put(Constants.PEOPLE, People.class);
        entities.put(Constants.PLANET, Planet.class);
        return entities;
    };
}
