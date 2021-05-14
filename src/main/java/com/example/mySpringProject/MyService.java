package com.example.mySpringProject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyService {

    private final RestTemplate restTemplate;

    @Value("${endpoint:http://randomuser.me/api/}")
    private String endpoint;

    public MyService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getUsers() {
        String result = restTemplate.getForObject(endpoint, String.class);
        System.out.println(result);
        return result;
    }
}
