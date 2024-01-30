package com.starwars.project.model.entity;

import java.util.List;

public record GeneralResponse(
        List<Object> results
) {
}
