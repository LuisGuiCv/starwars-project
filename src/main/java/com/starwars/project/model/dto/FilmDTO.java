package com.starwars.project.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

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
