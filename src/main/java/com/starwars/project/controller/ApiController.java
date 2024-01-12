package com.starwars.project.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.starwars.project.model.dto.FilmDTO;
import com.starwars.project.service.StarWarsServiceImpl;
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


    @Autowired
    StarWarsServiceImpl starWarsService;
    @GetMapping("/movies/{movieId}")
    public ResponseEntity<FilmDTO> getMovie(@PathVariable Integer movieId) throws JsonProcessingException {
        FilmDTO retrieveMovie=starWarsService.getMovieData(movieId);
        return new ResponseEntity<FilmDTO>(retrieveMovie, HttpStatus.OK);
    }
}
