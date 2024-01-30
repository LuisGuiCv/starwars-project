package com.starwars.project.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
/**
 * this Entity object will be used to save the converted Json Response of the "starships" endpoint in the StarWars API
 * @author Luis Guillermo Cruz Vargas
 * @version 1.0
 * @since 01/15/2024
 */
public record Starship(String name,
                       String model,
                       String manufacturer,
                       @JsonProperty("cost_in_credits")
                       Double costInCredits,
                       String length,
                       @JsonProperty("max_atmosphering_speed")
                       String maxAtmospheringSpeed,
                       String crew,
                       String passengers,
                       @JsonProperty("cargo_capacity")
                       Double cargoCapacity,
                       String consumables,
                       @JsonProperty("hyperdrive_rating")
                       Double hyperdriveRating,
                       Integer MGLT,
                       @JsonProperty("starship_class")
                       String starshipClass,
                       List<String> pilots,
                       List<String> films,
                       Date created,
                       Date edited,
                       String url) {
}
