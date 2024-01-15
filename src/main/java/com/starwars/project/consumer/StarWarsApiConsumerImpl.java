package com.starwars.project.consumer;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.project.controller.ApiController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.HashMap;

@Component
public class StarWarsApiConsumerImpl implements StarWarsApiConsumer {
    Logger logger = LoggerFactory.getLogger(StarWarsApiConsumerImpl.class);

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private HashMap<String,Class<?>> entityClasses;

    @Autowired
    ObjectMapper objectMapper;



    @Override
    public String makeApiCall (String url) throws WebClientResponseException {
        return webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
    @Override
    public Object convertJsonToObject(String jsonResponse, String entity) throws JsonProcessingException {
        HashMap<String, Object> convertJsonResponseToHashMap = objectMapper.readValue(jsonResponse, HashMap.class);
         convertJsonResponseToHashMap.replaceAll((key, value) ->  value!=null && (value.equals("unknown")|| value.equals("n/a"))? value=null : value);
        return objectMapper.convertValue(convertJsonResponseToHashMap, entityClasses.get(entity));
    }
}
