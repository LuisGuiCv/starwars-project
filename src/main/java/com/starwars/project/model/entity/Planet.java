package com.starwars.project.model.entity;

import java.util.List;

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
