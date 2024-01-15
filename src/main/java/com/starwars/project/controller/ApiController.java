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

@RestController
@RequestMapping("/api")
public class ApiController {

    Logger logger = LoggerFactory.getLogger(ApiController.class);


    @Autowired
    StarWarsServiceImpl starWarsService;
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
