package com.example;

/**
 * Created by yuanchen on 4/24/16.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherMain {
    private float temp;

    public WeatherMain() {
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getTemp() {

        return temp;
    }
}
