package com.starwars.project.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.starwars.project.consumer.StarWarsApiConsumer;
import com.starwars.project.model.dto.CharacterDTO;
import com.starwars.project.model.dto.FilmDTO;
import com.starwars.project.model.entity.GeneralResponse;
import com.starwars.project.model.entity.Movie;
import com.starwars.project.model.entity.People;
import com.starwars.project.util.exception.StarWarsSequelsException;
import com.starwars.project.util.helper.Constants;
import com.starwars.project.util.helper.StarWarsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
/**
 * this is the Service class where the business logic of the application id coded.
 * @author Luis Guillermo Cruz Vargas
 * @version 1.0
 * @since 01/15/2024
 */

@Service
public class StarWarsServiceImpl implements StarWarsService{

    @Autowired
    StarWarsHelper starWarsHelper;

    @Autowired
    FilmDTO filmDTO;

    @Autowired
    List<CharacterDTO> characterDTOList;




    @Value("${STAR_WARS_API_URL}")
    private String starWarsApiUrl;

    @Override
    public FilmDTO getMovieData(Integer movieId) throws JsonProcessingException {
        Movie retrievedfilm=(Movie) starWarsHelper.retrieveFromApi(movieId,Constants.FILMS);
        filmDTO.setTitle(retrievedfilm.name());
        filmDTO.setEpisodeId(retrievedfilm.episodeId());
        filmDTO.setOpeningCrawl(retrievedfilm.openingCrawl());
        filmDTO.setDirector(retrievedfilm.director());
        filmDTO.setProducer(retrievedfilm.producer());
        filmDTO.setReleaseDate(retrievedfilm.releaseDate());
        filmDTO.setCharacters(starWarsHelper.retrieveCharacterList(retrievedfilm.characters()).stream().map(character->character.name()).collect(Collectors.toList()));
        filmDTO.setPlanets(starWarsHelper.retrievePlanetsList(retrievedfilm.planets()).stream().map(planet -> planet.name()).collect(Collectors.toList()));
        filmDTO.setVehicles(starWarsHelper.retrieveVehiclesList(retrievedfilm.vehicles()).stream().map(vehicle -> vehicle.name()).collect(Collectors.toList()));
        filmDTO.setStarships(starWarsHelper.retrieveStarshipsList(retrievedfilm.starships()).stream().map(starship -> starship.name()).collect(Collectors.toList()));
        filmDTO.setSpecies(starWarsHelper.retrieveSpeciesList(retrievedfilm.species()).stream().map(species -> species.name()).collect(Collectors.toList()));
        filmDTO.setCreated(retrievedfilm.created());
        filmDTO.setEdited(retrievedfilm.edited());
        return filmDTO;
    }

    @Override
    public List<CharacterDTO> getCharactersByHeight(Double inputHeight) throws JsonProcessingException {
        double retrievedHeight;
        characterDTOList.clear();
        GeneralResponse generalResponse = (GeneralResponse) starWarsHelper.retrieveFromApi(starWarsApiUrl+"people",Constants.GENERAL_RESPONSE);
        List<Object> resultList=starWarsHelper.extractResponse(generalResponse);
        for(int key=0;key<resultList.size();key++){
           retrievedHeight= Double.parseDouble(String.valueOf(((LinkedHashMap) resultList.get(key)).get("height").toString()));

            if(retrievedHeight>=inputHeight){
                CharacterDTO characterDTO=new CharacterDTO();
                characterDTO.setHeight(retrievedHeight);
                characterDTO.setName(((LinkedHashMap) resultList.get(key)).get("name").toString());
                characterDTOList.add(characterDTO);

            }
        }
        return characterDTOList;
    }

    @Override
    public List<CharacterDTO> getCharactersByName(String letter) throws JsonProcessingException {
        characterDTOList.clear();
        GeneralResponse generalResponse = (GeneralResponse) starWarsHelper.retrieveFromApi(starWarsApiUrl+"people",Constants.GENERAL_RESPONSE);
        List<Object> resultList=starWarsHelper.extractResponse(generalResponse);
        for(int key=0;key<resultList.size();key++){
           String name= String.valueOf(((LinkedHashMap) resultList.get(key)).get("name").toString());
            if(String.valueOf(name.charAt(0)).equalsIgnoreCase(letter)){
                CharacterDTO characterDTO=new CharacterDTO();
                characterDTO.setName(((LinkedHashMap) resultList.get(key)).get("name").toString());
                characterDTOList.add(characterDTO);

            }
        }
        return characterDTOList;
    }


}


