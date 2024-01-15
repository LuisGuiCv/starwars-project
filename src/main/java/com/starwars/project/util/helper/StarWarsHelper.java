package com.starwars.project.util.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.starwars.project.consumer.StarWarsApiConsumerImpl;
import com.starwars.project.controller.ApiController;
import com.starwars.project.model.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StarWarsHelper {

    Logger logger = LoggerFactory.getLogger(StarWarsHelper.class);
    @Value("${STAR_WARS_API_URL}")
    private String starWarsApiUrl;
    @Autowired
    StarWarsApiConsumerImpl starWarsApiConsumerImpl;

    public List<People> retrieveCharacterList(List<String> characterList)  {
        logger.info("retrieving character's information from Star Wars API");
        List<People> retrievedCharactersFromApi = characterList.stream().map(character -> {
            People people = null;
            try {
                people = (People) this.retrieveFromApi(character, Constants.PEOPLE);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return people;

        }).collect(Collectors.toList());
        logger.info("characters retrieved: {}",retrievedCharactersFromApi);
        return retrievedCharactersFromApi;
    }


    public List<Planet> retrievePlanetsList(List<String> planetList) {
        logger.info("retrieving planet's information from Star Wars API");
        List<Planet> retrievedPlanetsList = planetList.stream().map(p -> {
            Planet planet = null;
            try {
                planet = (Planet) this.retrieveFromApi(p, Constants.PLANET);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return planet;

        }).collect(Collectors.toList());
        logger.info("planets retrieved: {}",retrievedPlanetsList);
        return retrievedPlanetsList;
    }
    public List<Vehicle> retrieveVehiclesList(List<String> vehicleList) {
        logger.info("retrieving vehicles information from Star Wars API");
        List<Vehicle> retrievedVehiclesList = vehicleList.stream().map(v -> {
            Vehicle vehicle = null;
            try {
                vehicle = (Vehicle) this.retrieveFromApi(v, Constants.VEHICLES);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return vehicle;

        }).collect(Collectors.toList());
        logger.info("vehicles retrieved: {}",retrievedVehiclesList);
        return retrievedVehiclesList;
    }
    public List<Starship> retrieveStarshipsList(List<String> starshipsList) {
        logger.info("retrieving starships information from Star Wars API");
        List<Starship> retrievedStarshipsList = starshipsList.stream().map(s -> {
            Starship starship = null;
            try {
                starship = (Starship) this.retrieveFromApi(s, Constants.STARSHIPS);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return starship;

        }).collect(Collectors.toList());
        logger.info("starships retrieved: {}",retrievedStarshipsList);
        return retrievedStarshipsList;
    }
    public List<Species> retrieveSpeciesList(List<String> speciesList) {
        logger.info("retrieving species information from Star Wars API");

        List<Species> retrievedSpeciesList = speciesList.stream().map(sp -> {
            Species species = null;
            try {
                species = (Species) this.retrieveFromApi(sp, Constants.SPECIES);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return species;

        }).collect(Collectors.toList());
        logger.info("species retrieved: {}",retrievedSpeciesList);
        return retrievedSpeciesList;
    }

    public Object retrieveFromApi(Integer id,String apiParam) throws JsonProcessingException {
        String url=starWarsApiUrl + "/"+ apiParam +"/" + id;
        logger.info("making client API call to StarWars API with the following URL {}",url);
        String jsonResponse= starWarsApiConsumerImpl.makeApiCall(url);
        logger.info("Succesfully fetched Response from API with the following response: {}",jsonResponse);
        return starWarsApiConsumerImpl.convertJsonToObject(jsonResponse,apiParam);
    }


    public Object retrieveFromApi(String url,String apiParam) throws JsonProcessingException {
        logger.info("making client API call to StarWars API with the following URL {}",url);
        String jsonResponse= starWarsApiConsumerImpl.makeApiCall(url);
        return starWarsApiConsumerImpl.convertJsonToObject(jsonResponse,apiParam);
    }
}
