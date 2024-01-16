package com.starwars.project.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.starwars.project.model.dto.FilmDTO;
import com.starwars.project.model.entity.Movie;
import com.starwars.project.util.exception.StarWarsSequelsException;
import com.starwars.project.util.helper.Constants;
import com.starwars.project.util.helper.StarWarsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



}
