package com.starwars.project.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

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
