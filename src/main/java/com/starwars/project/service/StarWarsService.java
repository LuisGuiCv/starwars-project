package com.starwars.project.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.starwars.project.model.dto.FilmDTO;

import java.util.List;

public interface StarWarsService {

    FilmDTO getMovieData(Integer movieId) throws JsonProcessingException;

}
