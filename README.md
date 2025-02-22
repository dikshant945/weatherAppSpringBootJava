# Weather App

## Overview
This is a simple weather application built using Spring Boot, Thymeleaf, and JavaScript. It allows users to retrieve current weather details by entering a city and country. The app integrates with a weather API to fetch real-time weather data.

## Features
- Fetches real-time weather data based on user input (city & country)
- Displays temperature, humidity, pressure, wind speed, and general weather conditions
- Error handling for invalid locations or API failures
- Modern UI with Bootstrap styling

## API Key Notice
For a limited time, a default API key has been provided. However, in the future, you must use your own API key.

### Configuration:
- Add your API key in `application.properties` as follows:
  ```
  weather.apiKey=YOUR_OWN_API_KEY
  ```
- Update the API call in the backend to use this key.

## How to Run
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/weather-app.git
   cd weather-app
   ```
2. Configure your API key in `application.properties`.
3. Build and run the Spring Boot application:
   ```sh
   mvn spring-boot:run
   ```
4. Open your browser and visit `http://localhost:8080`.

## Screenshots
![Weather App Screenshot](https://github.com/dikshant945/weatherAppSpringBootJava/blob/master/src/main/resources/static/working.png)


## Future Improvements
- Adding a 7-day forecast feature
- Implementing user location-based weather retrieval
- Enhancing UI with dynamic weather animations

## Contributions
Feel free to fork the repository and submit pull requests for improvements.

