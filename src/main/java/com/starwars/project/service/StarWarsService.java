package com.starwars.project.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.starwars.project.consumer.StarWarsApiConsumerImpl;
import com.starwars.project.model.dto.FilmDTO;

/**
 * this is the interface that will be used as a contract for the {@link StarWarsServiceImpl} class.
 * @author Luis Guillermo Cruz Vargas
 * @version 1.0
 * @since 01/15/2024
 */

public interface StarWarsService {
    /**
     * this method will call the Movie Entity object and save the response in a  {@link FilmDTO} object. sometimes the attributes are Lists that contains
     * StarWarsAPI URLS, depending on the attribute, the method will call the methods that  will transform this List of urls into a List of Entity objects
     * and with new List the method will generate a new String List that will be stored in the respective filmDTO object.
     *
     *
     * @param movieId-> this parameter is given by the end-user and is used to select the movie desired
     * @return this method returns the FilmDTO object after the businesss logic has been applied{@link FilmDTO}.
     * @throws JsonProcessingException this exception will trigger if there is an issue while converting the Json Response to a Java class.
     */
    FilmDTO getMovieData(Integer movieId) throws JsonProcessingException;

}
