package com.fareye.training.resttemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

public class RestTemplateProvider {

    public static RestTemplate restTemplate = new RestTemplate();

     public static String getavtar(String userName) throws JsonProcessingException {


         String Baseurl = "https://api.github.com/users/"+userName;
         String jsonString = restTemplate.getForObject(Baseurl,String.class);
         ObjectMapper mapper = new ObjectMapper();
         String avatalUrl = mapper.readTree(jsonString).get("avatar_url").asText();
         return avatalUrl;
     }

}
