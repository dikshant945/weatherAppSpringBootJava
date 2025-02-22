package com.example.weather.Service;

import org.json.JSONArray;
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

    @Value("${weather.url.historical}")
    private String HISTORICAL_BASE_URL;


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

    public List<Map<String, String>> getHistoricalWeather(String cityName, String country, String fromDate, String toDate) {
        String url = HISTORICAL_BASE_URL + "?q=" + cityName + "," + country + "&appid=" + API_KEY + "&start=" + fromDate + "&end=" + toDate + "&units=metric";
        RestTemplate restTemplate = new RestTemplate();

        List<Map<String, String>> historicalData = new ArrayList<>();

        try {
            String response = restTemplate.getForObject(url, String.class);
            JSONObject jsonResponse = new JSONObject(response);

            if (jsonResponse.has("cod") && jsonResponse.getInt("cod") != 200) {
                throw new RuntimeException(jsonResponse.getString("message"));
            }

            JSONArray dataList = jsonResponse.getJSONArray("list");

            for (int i = 0; i < dataList.length(); i++) {
                JSONObject dayData = dataList.getJSONObject(i);

                Map<String, String> dayWeather = new HashMap<>();
                dayWeather.put("date", dayData.getString("dt_txt"));
                dayWeather.put("temperature", String.valueOf(dayData.getJSONObject("main").getDouble("temp")));
                dayWeather.put("condition", dayData.getJSONArray("weather").getJSONObject(0).getString("main"));
                dayWeather.put("humidity", String.valueOf(dayData.getJSONObject("main").getInt("humidity")));
                dayWeather.put("windSpeed", String.valueOf(dayData.getJSONObject("wind").getDouble("speed")));

                historicalData.add(dayWeather);
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to fetch historical data: " + e.getMessage());
        }

        return historicalData;
    }

}
