package com.starwars.project.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * this Entity object will be used to save the converted Json Response of the "movies" endpoint in the StarWars API
 * @author Luis Guillermo Cruz Vargas
 * @version 1.0
 * @since 01/15/2024
 */
public record Movie(
                    @JsonProperty("title")
                     String name,
                     @JsonProperty("episode_id")
                     String episodeId,
                     @JsonProperty("opening_crawl")
                     String openingCrawl,
                     String director,
                     String producer,
                     @JsonProperty("release_date")
                     Date releaseDate,
                     List<String> characters,
                     List<String> planets,
                     List<String> starships,
                     List<String> vehicles,
                     List<String> species,
                     Date created,
                     Date edited) {
}
