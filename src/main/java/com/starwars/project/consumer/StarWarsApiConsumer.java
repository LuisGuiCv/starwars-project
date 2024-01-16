package com.starwars.project.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * this is the interface that will be used as a contract for the {@link StarWarsApiConsumerImpl} class.
 * @author Luis Guillermo Cruz Vargas
 * @version 1.0
 * @since 01/15/2024
 */
public interface StarWarsApiConsumer {


    /**
     * this method will transform the JsonResponse into a Entity Object using an Entity
     * String to determine which Entity class the JSON response will be mapped.
     *
     * @param jsonResponse-> this is the jsonResponse that will be mapped into the Entity class
     * @param entity -> this is the parameter that will determine the Entity class that the
     * JSON response will be mapped.
     * @return this will return the mapped Entity object
     * @throws JsonProcessingException this exception will trigger if there is an issue while converting the Json Response to a Java class.
     */

    Object convertJsonToObject(String jsonResponse, String entity) throws JsonProcessingException;

    /**
     * this method will transform the JsonResponse into a Entity Object using an Entity
     * String to determine which Entity class the JSON response will be mapped.
     *
     * @param url -> this is the url that will be used to make the API call to StarwarsApi
     * @return this will return the Json response as a String.
     */
    String makeApiCall(String url);
}
