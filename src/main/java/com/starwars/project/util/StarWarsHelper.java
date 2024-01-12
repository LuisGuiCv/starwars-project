package com.starwars.project.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.starwars.project.consumer.StarWarsApiConsumerImpl;
import com.starwars.project.model.entity.People;
import com.starwars.project.model.entity.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StarWarsHelper {
    @Value("${STAR_WARS_API_URL}")
    private String starWarsApiUrl;
    @Autowired
    StarWarsApiConsumerImpl starWarsApiConsumerImpl;

    public List<String> retrieveCharacterList(List<String> characterList)  {
        return characterList.stream().map(character -> {
            People people = null;
            try {
                people = (People) this.retrieveFromApi(character,Constants.PEOPLE);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return people.name();

        }).collect(Collectors.toList());
    }


    public List<String> retrievePlanetsList(List<String> planetList) {
        return planetList.stream().map(p -> {
            Planet planet = null;
            try {
                planet = (Planet) this.retrieveFromApi(p,Constants.PLANET);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return planet.name();

        }).collect(Collectors.toList());
    }


    public Object retrieveFromApi(Integer id,String apiParam) throws JsonProcessingException {
        String url=starWarsApiUrl + "/"+ apiParam +"/" + id;
        String jsonResponse= starWarsApiConsumerImpl.makeApiCall(url);
        return starWarsApiConsumerImpl.convertJsonToObject(jsonResponse,apiParam);
    }


    public Object retrieveFromApi(String url,String apiParam) throws JsonProcessingException {
        String jsonResponse= starWarsApiConsumerImpl.makeApiCall(url);
        return starWarsApiConsumerImpl.convertJsonToObject(jsonResponse,apiParam);
    }
}
