package com.starwars.project.config;

import com.starwars.project.consumer.StarWarsApiConsumerImpl;
import com.starwars.project.model.dto.CharacterDTO;
import com.starwars.project.model.dto.FilmDTO;
import com.starwars.project.model.entity.*;
import com.starwars.project.service.StarWarsServiceImpl;
import com.starwars.project.util.helper.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * this is the spring configuration class that will create the necessary beans of the project.
 * @author Luis Guillermo Cruz Vargas
 * @version 1.0
 * @since 01/15/2024
 */
@Configuration
public class SpringConfig {
    /**
     * this  WebClient Bean will be used to make the actual API call to StarWarsAPi in the {@link StarWarsApiConsumerImpl} class
     * @author Luis Guillermo Cruz Vargas
     * @version 1.0
     * @return it wil return the JsonResponse as a String
     * @since 01/15/2024
     */
    @Bean
    public WebClient.Builder getWebClientBuilder(){
        return WebClient.builder();
    }

    /**
     * here the filmDTO bean is created to be used as a singleton in the {@link StarWarsServiceImpl} class.
     */

    @Bean
    public List<CharacterDTO> characterDTOList() {
        List<CharacterDTO> characterDTOList = new ArrayList<>();
        return characterDTOList;}
    @Bean
    CharacterDTO characterDTO() {return new CharacterDTO();}


    @Bean
    FilmDTO filmDTO(){
        return new FilmDTO();
    }

    /**
     * this hashMap will be used in the {@link StarWarsApiConsumerImpl} class to
     * determine in whichEntity Object the JsonResponse from the StarWarsAPI will be saved.
     * @author Luis Guillermo Cruz Vargas
     * @version 1.0
     * @since 01/15/2024
     */
    @Bean
    HashMap<String,Class<?>> entityClasses(){
        HashMap<String, Class<?>> entities=new HashMap<>();
        entities.put(Constants.FILMS, Movie.class);
        entities.put(Constants.PEOPLE, People.class);
        entities.put(Constants.PLANET, Planet.class);
        entities.put(Constants.VEHICLES, Vehicle.class);
        entities.put(Constants.STARSHIPS, Starship.class);
        entities.put(Constants.SPECIES, Species.class);
        entities.put(Constants.GENERAL_RESPONSE, GeneralResponse.class);
        return entities;
    };
}
