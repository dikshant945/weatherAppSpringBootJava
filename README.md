# Weather App

## Overview
This is a simple weather application built using **Spring Boot, Thymeleaf, and JavaScript**. It allows users to retrieve **current weather details** by entering a city and country also it shows the historical data due to free trial api for now it show historical data for 5 days only.  The app integrates with the **OpenWeather API** to fetch real-time weather data, with additional features such as **unit switching** and **caching mechanisms** to reduce API calls and improve performance.


## User Interface
The application features a **simple and intuitive UI**, designed for ease of use:
- A **search functionality** where users can input a city name to retrieve weather data.
- A **date range filter** allowing users to view historical weather information.
- A **display of key weather details** such as temperature, humidity, and wind speed in a user-friendly format.

## Functionality
- **Real-Time Data:** Uses the OpenWeather API to fetch weather data based on user input.
- **Error Handling:** Gracefully handles API responses and errors.
- **Responsive Design:** The application works across different devices and screen sizes.
- **Enhanced Features:**
  - **Unit Switching:** Users can toggle between Celsius and Fahrenheit.
  - **Caching:** Implemented caching mechanisms to reduce API calls and improve performance.

## Technical Specifications
### **Technologies Used:**
- **Backend:** Spring Boot, Java11
- **Frontend:** Thymeleaf, JavaScript, Bootstrap
- **API:** OpenWeather API

### **API Key Management:**
- API keys are **managed securely** and should **not be hardcoded** into source files.
- Currently free API key is present but in future you should use it your own provide API key


## Setup and Running the Application
### **Clone the Repository:**
```sh
git clone https://github.com/dikshant945/weatherAppSpringBootJava.git
cd weatherAppSpringBootJava
```

### **Configure the API Key:**
Open the `application.properties` file and add your API key:
```ini
weather.apiKey=YOUR_OWN_API_KEY
```

### **Build and Run the Application:**
```sh
mvn spring-boot:run
```

### **Access the Application:**
Open your browser and navigate to:
```
http://localhost:8080
```

## Prerequisites and Dependencies
- **Java Development Kit (JDK)**
- **Maven**
- **Internet Connection** for accessing the OpenWeather API

## Optional Enhancements
- **Localization:** Future versions may include **multiple language support**.
- **Extended Forecasts:** Possibility of including **weather forecasts** for upcoming days.

## Working
![Weather App working ui page](https://github.com/dikshant945/weatherAppSpringBootJava/blob/master/src/main/resources/static/workingImages/working1.png)
![Weather App working data](https://github.com/dikshant945/weatherAppSpringBootJava/blob/master/src/main/resources/static/workingImages/working2.png)
![Weather App working historical data](https://github.com/dikshant945/weatherAppSpringBootJava/blob/master/src/main/resources/static/workingImages/working3.png)

---

### **Contributions**
Feel free to submit **issues** or **pull requests** to improve this project.

📌 **Author:** Dikshant Sharma
📌 **GitHub:** https://github.com/dikshant945

