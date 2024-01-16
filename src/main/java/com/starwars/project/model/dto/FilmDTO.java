package com.starwars.project.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
/**
 * this FilmDTO will be used to transfer the movie information after the business logic in the Servic class has been applied.
 * @author Luis Guillermo Cruz Vargas
 * @version 1.0
 * @since 01/15/2024
 */
@Data
public class FilmDTO{

    private String title;
    private String episodeId;
    private String openingCrawl;
    private String director;
    private String producer;
    private Date releaseDate;
    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;
    private Date created;
    private Date edited;

}
