package com.fareye.training;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TrainingApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(TrainingApplication.class, args);
        System.out.println("Heloo world");



    }

}
