package com.starwars.project.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
/**
 * this Entity object will be used to save the converted Json Response of the "people" endpoint in the StarWars API
 * @author Luis Guillermo Cruz Vargas
 * @version 1.0
 * @since 01/15/2024
 */
public record People(String name,
                     Integer height,
                     String mass,
                     @JsonProperty("hair_color")
                     String hairColor,
                     @JsonProperty("skin_color")
                     String skinColor,
                     @JsonProperty("eye_color")
                     String eyeColor,
                     @JsonProperty("birth_year")
                     String birthYear,
                     String gender,
                     String homeworld,
                     List<String> films,
                     List<String> species,
                     List<String> vehicles,
                     List<String> starships,
                     Date created,
                     Date edited) {
}
