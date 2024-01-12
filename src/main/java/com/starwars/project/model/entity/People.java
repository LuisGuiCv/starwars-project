package com.starwars.project.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

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
