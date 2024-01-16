package com.starwars.project.model.entity;

import java.util.List;
/**
 * this Entity object will be used to save the converted Json Response of the "planets" endpoint in the StarWars API
 * @author Luis Guillermo Cruz Vargas
 * @version 1.0
 * @since 01/15/2024
 */
public record Planet(String name,
                     String diameter,
                     String rotation_period,
                     String orbital_period,
                     String gravity,
                     String population,
                     String climate,
                     String terrain,
                     String surface_water,
                     List<String> residents,
                     List<String> films,
                     String url,
                     String created,
                     String edited
) {
}
