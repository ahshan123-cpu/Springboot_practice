package com.employee.wireMockDemo.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class GithubConfig {

    private final RestTemplate restTemplate;
    public GithubConfig(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    public Map<String, Object> getUserInfo(String username) {
        String url = "https://api.github.com/users/" + username;
        return restTemplate.getForObject(url, Map.class);
    }
}
