package com.starwars.project.consumer;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.project.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;

@Component
public class StarWarsApiConsumerImpl implements StarWarsApiConsumer {




    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private HashMap<String,Class<?>> entityClasses;

    @Autowired
    ObjectMapper objectMapper;



    @Override
    public String makeApiCall(String url) {
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
         convertJsonResponseToHashMap.replaceAll((key, value) -> value.equals("unknown") ? value=null : value);
        return objectMapper.convertValue(convertJsonResponseToHashMap, entityClasses.get(entity));
    }
}
