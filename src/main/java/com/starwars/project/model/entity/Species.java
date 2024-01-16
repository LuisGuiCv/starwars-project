package com.starwars.project.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
/**
 * this Entity object will be used to save the converted Json Response of the "species" endpoint in the StarWars API
 * @author Luis Guillermo Cruz Vargas
 * @version 1.0
 * @since 01/15/2024
 */
public record Species (Double average_height,
                       @JsonProperty("average_lifespan")
                      String averageLifespan,
                      String classification,
                      Date created,
                      String designation,
                      Date edited,
                       @JsonProperty("eye_colors")
                      String eyeColors,
                       @JsonProperty("hair_colors")
                      String hairColors,
                      String homeworld,
                      String language,
                      String name,
                      List<String> people,
                      List<String> films,
                       @JsonProperty("skin_colors")
                       String skinColors,
                      String url){
}
