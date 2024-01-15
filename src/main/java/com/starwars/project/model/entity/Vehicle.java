package com.starwars.project.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public record Vehicle(String name,
                      String model,
                      String manufacturer,
                      @JsonProperty("cost_in_credits")
                      Double costInCredits,
                      Double length,
                      @JsonProperty("max_atmosphering_speed")
                      Double maxAtmospheringSpeed,
                      Integer crew,
                      Integer passengers,
                      @JsonProperty("cargo_capacity")
                      String cargoCapacity,
                      String consumables,
                      @JsonProperty("vehicle_class")
                      String vehicleClass,
                      List<String> pilots,
                      List<String> films,
                      Date created,
                      Date edited,
                      String url) {


}
