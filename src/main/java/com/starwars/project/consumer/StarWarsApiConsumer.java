package com.starwars.project.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface StarWarsApiConsumer {




    Object convertJsonToObject(String jsonResponse, String apiParam) throws JsonProcessingException;


    Object makeApiCall(String url);
}
