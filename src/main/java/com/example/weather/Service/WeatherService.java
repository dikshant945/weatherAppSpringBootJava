package com.example.weather.Service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.*;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.url}")
    private String BASE_URL;

    @Value("${weather.apiKey}")
    private String API_KEY;


    public Map<String,String> getCurrentWeather(String cityName, String country) {

        String url = BASE_URL + "?q=" + cityName + "," + country + "&appid=" + API_KEY + "&units=metric";
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> weatherData = new HashMap<>();

        try {
            String response = restTemplate.getForObject(url, String.class);
            JSONObject jsonResponse = new JSONObject(response);

            if (jsonResponse.has("cod") && jsonResponse.getInt("cod") != 200) {
                weatherData.put("error", jsonResponse.getString("message")); // Example: "city not found"
                return weatherData;
            }

            String weatherMain = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("main");
            String weatherDescription = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("description");
            double tempValue = jsonResponse.getJSONObject("main").getDouble("temp");
            int humidity = jsonResponse.getJSONObject("main").getInt("humidity");
            int pressure = jsonResponse.getJSONObject("main").getInt("pressure");
            double windSpeed = jsonResponse.getJSONObject("wind").getDouble("speed");

            weatherData.put("cityName", cityName);
            weatherData.put("country", country);
            weatherData.put("weatherMain", weatherMain);
            weatherData.put("weatherDescription", weatherDescription);
            weatherData.put("tempValue", String.valueOf(tempValue));
            weatherData.put("humidity", String.valueOf(humidity));
            weatherData.put("pressure", String.valueOf(pressure));
            weatherData.put("windSpeed", String.valueOf(windSpeed));

        } catch (Exception e) {
            weatherData.put("error", "Unable to fetch weather data EXCEPTION :: " + e.getMessage());
        }

        return weatherData;
    }
}
