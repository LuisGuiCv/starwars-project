package com.starwars.project.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;


public record Film(String title,
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
