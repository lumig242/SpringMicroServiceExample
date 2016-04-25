package com.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@RestController
public class GetExternalIPController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/ip")
    public String getIP () {
        restTemplate = new RestTemplate();
        return getExternalIP();

    }

    private String getExternalIP() {
        StringBuilder builder = new StringBuilder();
        try {

            URL url = new URL("http://myexternalip.com/raw");

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
