package com.starwars.project.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

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
