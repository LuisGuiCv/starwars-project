package com.starwars.project.config;

import com.starwars.project.model.dto.FilmDTO;
import com.starwars.project.model.entity.*;
import com.starwars.project.util.helper.Constants;
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
        entities.put(Constants.FILMS, Movie.class);
        entities.put(Constants.PEOPLE, People.class);
        entities.put(Constants.PLANET, Planet.class);
        entities.put(Constants.VEHICLES, Vehicle.class);
        entities.put(Constants.STARSHIPS, Starship.class);
        entities.put(Constants.SPECIES, Species.class);
        return entities;
    };
}
