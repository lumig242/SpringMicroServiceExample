package com.example;

/**
 * Created by yuanchen on 4/24/16.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {
    private ArrayList<Weather> weather;
    private WeatherMain main;

    public WeatherInfo() {
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }

    public ArrayList<Weather> getWeather() {

        return weather;
    }


    public WeatherMain getMain() {
        return main;
    }

    public void setMain(WeatherMain main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "weather: "+weather.get(0).toString() +"\n"+"temp: " +main.getTemp();
    }
}
