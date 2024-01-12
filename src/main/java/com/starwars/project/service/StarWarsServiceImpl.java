package com.starwars.project.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.starwars.project.model.dto.FilmDTO;
import com.starwars.project.model.entity.Film;
import com.starwars.project.model.entity.People;
import com.starwars.project.consumer.StarWarsApiConsumerImpl;
import com.starwars.project.model.entity.Planet;
import com.starwars.project.util.Constants;
import com.starwars.project.util.StarWarsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsServiceImpl implements StarWarsService{

    @Autowired
    StarWarsHelper starWarsHelper;

    @Autowired
    FilmDTO filmDTO;
    @Override
    public FilmDTO getMovieData(Integer movieId) throws JsonProcessingException {
        Film retrievedfilm=(Film) starWarsHelper.retrieveFromApi(movieId,Constants.FILMS);
        filmDTO.setTitle(retrievedfilm.title());
        filmDTO.setEpisodeId(retrievedfilm.episodeId());
        filmDTO.setOpeningCrawl(retrievedfilm.openingCrawl());
        filmDTO.setDirector(retrievedfilm.director());
        filmDTO.setProducer(retrievedfilm.producer());
        filmDTO.setReleaseDate(retrievedfilm.releaseDate());
        filmDTO.setCharacters(starWarsHelper.retrieveCharacterList(retrievedfilm.characters()));
        filmDTO.setPlanets(starWarsHelper.retrievePlanetsList(retrievedfilm.planets()));
        return filmDTO;
    }

}
