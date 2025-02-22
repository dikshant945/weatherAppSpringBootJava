package com.example.weather.controller;

import com.example.weather.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/getCurrentWeather")
    @ResponseBody // Ensure JSON response
    public Map<String, String> getWeather(@RequestParam(defaultValue = "Delhi") String cityName,
        @RequestParam(defaultValue = "IN") String country) {

        return weatherService.getCurrentWeather(cityName, country);
    }

    @GetMapping("/getHistoricalWeather")
    @ResponseBody
    public List<Map<String, String>> getHistoricalWeather(@RequestParam String cityName,
        @RequestParam String country, @RequestParam String fromDate, @RequestParam String toDate) {
        return weatherService.getHistoricalWeather(cityName, country, fromDate, toDate);
    }
}
