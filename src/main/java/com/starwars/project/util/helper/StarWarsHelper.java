package com.starwars.project.util.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.starwars.project.consumer.StarWarsApiConsumerImpl;
import com.starwars.project.model.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
/**
 * this class will be used for methods that will make repetitive calls to the API.
 * into an Entity object.
 * @author Luis Guillermo Cruz Vargas
 * @version 1.0
 * @since 01/15/2024
 */
@Component
public class StarWarsHelper {

    Logger logger = LoggerFactory.getLogger(StarWarsHelper.class);
    @Value("${STAR_WARS_API_URL}")
    private String starWarsApiUrl;
    @Autowired
    StarWarsApiConsumerImpl starWarsApiConsumerImpl;
    /**
     * this method will take a list of StarWars API "people" urls and will transform this url's
     * into People Entity Objects and save them in a People Entity list
     * String to determine which Entity class the JSON response will be mapped.
     *
     * @param characterList -> this is the list that will be transformed using streams
     * @return this will return a People Entity list
     */
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

    /**
     * this method will take a list of StarWars API "planets" urls and will transform this url's
     * into Planets Entity Objects and save them in a Planet Entity list
     * String to determine which Entity class the JSON response will be mapped.
     *
     * @param planetList -> this is the list that will be transformed using streams
     * @return this will return a Planet Entity list
    */
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
    /**
     * this method will take a list of StarWars API "vehicles" urls and will transform this url's
     * into Vehicle Entity Objects and save them in a Vehicle Entity list
     * String to determine which Entity class the JSON response will be mapped.
     *
     * @param vehicleList -> this is the list that will be transformed using streams
     * @return this will return a Vehicle Entity list
     */
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
    /**
     * this method will take a list of StarWars API "starships" urls and will transform this url's
     * into Starships Entity Objects and save them in a Starship Entity list
     * String to determine which Entity class the JSON response will be mapped.
     *
     * @param starshipsList -> this is the list that will be transformed using streams
     * @return this will return a Starship Entity list
     */
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
    /**
     * this method will take a list of StarWars API "species" urls and will transform this url's
     * into Species Entity Objects and save them in a Species Entity list
     * String to determine which Entity class the JSON response will be mapped.
     *
     * @param speciesList -> this is the list that will be transformed using streams
     * @return this will return a Planet Entity list
     */
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
    /**
     * this method will be the one that prepares the url,then it will use the makeApiCall(url)
     * method to make the API call to StarWars API.then
     * it will use the convertJsonToObject(jsonResponse,apiParam)
     * to transform the result into an Entity Class.
     *
     * @param id -> this id will be used to select the specific response from the StarWarsAPI
     * @param apiParam -> this will be used to prepare the url and will be used for the convertJsonObject method
     * @return this will return the mapped Entity object
     * @throws JsonProcessingException this exception will trigger if there is an issue while converting the Json Response to a Java class.
     */

    public Object retrieveFromApi(Integer id,String apiParam) throws JsonProcessingException {
        String url=starWarsApiUrl + "/"+ apiParam +"/" + id;
        logger.info("making client API call to StarWars API with the following URL {}",url);
        String jsonResponse= starWarsApiConsumerImpl.makeApiCall(url);
        logger.info("Succesfully fetched Response from API with the following response: {}",jsonResponse);
        return starWarsApiConsumerImpl.convertJsonToObject(jsonResponse,apiParam);
    }
    /**
     * this method will be the one to use the makeApiCall(url)
     * method to make the API call to StarWars API.
     *
     * @param url -> this is the url that will be used to make the StarWarsAPI call
     * @param apiParam -> this will be used to prepare the url and will be used for the convertJsonObject method
     * @return this will return the mapped Entity list
     * @throws JsonProcessingException this exception will trigger if there is an issue while converting the Json Response to a Java class.
     */

    public Object retrieveFromApi(String url,String apiParam) throws JsonProcessingException {
        logger.info("making client API call to StarWars API with the following URL {}",url);
        String jsonResponse= starWarsApiConsumerImpl.makeApiCall(url);
        return starWarsApiConsumerImpl.convertJsonToObject(jsonResponse,apiParam);
    }
}
