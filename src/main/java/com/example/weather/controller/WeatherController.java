package com.example.weather.controller;
import com.example.weather.Service.WeatherService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/getCurrentWeather")
    @ResponseBody // Ensure JSON response
    public Map<String, String> getWeather(@RequestParam(defaultValue = "Delhi") String cityName,
        @RequestParam(defaultValue = "IN") String country) {

       return weatherService.getCurrentWeather(cityName, country);
    }

}
