package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by kstain on 4/24/16.
 */
@RestController
public class HolidayServiceController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/holiday")
    public String getWeather (@RequestParam (value = "country" , defaultValue = "US") String country,
                              @RequestParam (value = "year" , defaultValue = "2016") String year) {
        restTemplate = new RestTemplate();
        JsonNode a = restTemplate.getForObject("http://holidayapi.com/v1/holidays?country="+country +"&year="+year,JsonNode.class);
        return a.toString();
    }
}