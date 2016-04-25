package com.example;
import java.net.*;
import java.io.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HistoryOfTodayController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/date")
    public String getWeather (@RequestParam(value = "month", defaultValue = "") String month,
                              @RequestParam(value = "day", defaultValue = "") String day) {
        restTemplate = new RestTemplate();
        StringBuilder builder = new StringBuilder();;
        URL url = null;
        try {
            System.out.println(month);
            System.out.println(day);
            if(month != null && day != null) {
                url = new URL("http://history.muffinlabs.com/date/" +
                        month + "/" + day);
            }
            else{
                url = new URL("http://history.muffinlabs.com/date");
            }

            URLConnection connection = url.openConnection();

            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch(java.io.FileNotFoundException e){
            return "Please check the input format!";
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
