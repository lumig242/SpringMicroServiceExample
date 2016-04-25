package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yuanchen on 4/24/16.
 */
@RestController
public class ZipServiceController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/zip")
    public String getWeather (@RequestParam (value = "zip" , defaultValue = "94043") String zip) {
        restTemplate = new RestTemplate();
        JsonNode a = restTemplate.getForObject("http://api.zippopotam.us/us/"+zip,JsonNode.class);
        return a.toString();
    }
}
