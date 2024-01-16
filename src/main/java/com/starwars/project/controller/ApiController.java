package com.starwars.project.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.starwars.project.model.dto.FilmDTO;
import com.starwars.project.service.StarWarsServiceImpl;
import com.starwars.project.util.exception.StarWarsSequelsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * this is the class where the endpoints of the application are coded. the endpoints you can find in this class are:
 * 1. getMovie(): /api/movies/{movieId}
 * @author Luis Guillermo Cruz Vargas
 * @version 1.0
 * @since 01/15/2024
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    Logger logger = LoggerFactory.getLogger(ApiController.class);


    @Autowired
    StarWarsServiceImpl starWarsService;
    /**
     * this method gets the movie information taking an movieId as parameter.
     *
     * @param movieId-> this parameter is given by the end-user and is used to select the movie desired
     * @return thie method returns the FilmDTO object wrapped in a Response entity {@link FilmDTO}.
     * @throws StarWarsSequelsException this exception will trigger if the movieId is between 7 and 9.
     @throws JsonProcessingException this exception will trigger if there is an issue while transforming the JsonResponse from the StarWarsAPI
     */
    @GetMapping("/movies/{movieId}")
    public ResponseEntity<FilmDTO> getMovie(@PathVariable Integer movieId) throws JsonProcessingException, StarWarsSequelsException {
        if(movieId>=7 &&movieId<=9){
            throw new StarWarsSequelsException();
        }
        logger.info("making getMovie API Call with movieId: {}",movieId);
        FilmDTO retrieveMovie=starWarsService.getMovieData(movieId);
        logger.info("Succesfully retrieved Movie with id: {}\nMovie Information: {}",movieId,retrieveMovie);
        return new ResponseEntity<FilmDTO>(retrieveMovie, HttpStatus.OK);
    }
}
