package com.starwars.project.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PeopleDTO {


    private String name;
    private int height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeWorld;
    private List< String> films;
    private List< String> species;
    private List< String> vehicles;
    private List< String> starships;
    private Date created;
    private Date edited;
}
