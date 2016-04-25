package com.example;
import java.net.*;
import java.io.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yuanchen on 4/24/16.
 */
@RestController
public class NewsSearchServiceController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/news")
    public String getWeather (@RequestParam(value = "key" , defaultValue = "qwe") String key) {
        restTemplate = new RestTemplate();
        StringBuilder builder = new StringBuilder();;
        URL url = null;
        try {
            url = new URL("https://ajax.googleapis.com/ajax/services/feed/find?" +
                    "v=1.0&q=" +
                    key +
                    "&userip=INSERT-USER-IP");
            URLConnection connection = url.openConnection();

            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while((line = reader.readLine()) != null) {
                builder.append(line);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
