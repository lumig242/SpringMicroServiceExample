package com.example;

/**
 * Created by yuanchen on 4/24/16.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    private String main;
    private String id;

    public Weather() {
    }

    public String getMain() {
        return main;
    }

    public String getId() {
        return id;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "main: "+main;
    }
}
