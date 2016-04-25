package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yuanchen on 4/24/16.
 */

@RestController
public class WeatherController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/weather")
    public String getWeather (@RequestParam (value = "location" , defaultValue = "Mountain View") String location) {
        restTemplate = new RestTemplate();
        WeatherInfo a = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q="+location+"&APPID=1f5bb55e11defbfd348ec29b52a051a2",WeatherInfo.class);
        return a.toString();
    }

}
