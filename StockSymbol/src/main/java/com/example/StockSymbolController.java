package com.example;

/**
 * Created by Holysoul on 4/25/16.
 */

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class StockSymbolController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/stock")
    public String getSymbol (@RequestParam (value = "symbol" , defaultValue = "AAPL") String symbol) {
        restTemplate = new RestTemplate();
        //JsonNode a = restTemplate.getForObject("http://dev.markitondemand.com/MODApis/Api/v2/Quote/jsonp?symbol="+symbol +"&callback=myFunction",JsonNode.class);
        //JsonNode a = restTemplate.getForObject("http://finance.google.com/finance/info?client=ig&q=NASDAQ%3"+symbol,JsonNode.class);//finance.google.com/finance/info?client=ig&q=NASDAQ%3AAPL
        JsonNode a = restTemplate.getForObject("http://finance.yahoo.com/webservice/v1/symbols/"+symbol+"/quote?format=json&view=detail",JsonNode.class);

        return a.toString();
    }
}

