package com.employee.details.services;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class PetStoreClientConfig {

    private final RestTemplate restTemplate;
//    private final RestClient restClient;

    public PetStoreClientConfig(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();

    }

    public Map<String, Object> getPetById(long petId) {
        String url = "/v2/pet/" + petId;
//        return restClient.get().uri(url)
        return restTemplate.getForObject(url, Map.class);
    }
}

