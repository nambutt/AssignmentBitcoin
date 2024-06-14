package com.example.assignment.controller;

import com.example.assignment.model.Bitcoin;
import com.example.assignment.service.BitcoinService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/api/")
public class BitcoinController {

    @Autowired
    private BitcoinService bitcoinService;

    @GetMapping("/fetch-and-save")
    public ResponseEntity<String> fetchAndSaveBitcoinPrices() throws JSONException, JsonProcessingException {
        // Call the API
        String apiUrl = "https://api.coindesk.com/v1/bpi/currentprice.json";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

        // Save the data to the database
        bitcoinService.saveBitcoinPrices(response.getBody());

        return ResponseEntity.ok("Data saved successfully");
    }
    @GetMapping("/show-data")
    public List<Bitcoin> showData()
    {
        return bitcoinService.getDatafromDB();
    }

}