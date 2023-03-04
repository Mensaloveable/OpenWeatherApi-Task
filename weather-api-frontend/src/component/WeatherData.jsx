import React, { useState } from "react";
import axios from "axios";
import "./WeatherData.css";

function WeatherData() {
  const [city, setCity] = useState("");
  const [weatherData, setWeatherData] = useState(null);
  const [error, setError] = useState(null);

  const parser = new DOMParser();

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError(null);
    try {
      const response = await axios.get(
        `http://localhost:8080/api/v1/weather/city/${city}`
      );
      const { data } = response;
      const xmlResponse = parser.parseFromString(data, "text/xml");
      const weatherElement = xmlResponse.getElementsByTagName("weather")[0];
      let weatherDescription =
        weatherElement.getElementsByTagName("description")[0].textContent;
      const words = weatherDescription.split(" ");

      const titleCaseWords = words.map((word) => {
        const firstLetter = word.charAt(0).toLocaleUpperCase();
        const restOfWord = word.slice(1).toLocaleLowerCase();
        return `${firstLetter}${restOfWord}`;
      });
      weatherDescription = titleCaseWords.join(" ");
      setWeatherData(weatherDescription);
    } catch (err) {
      setError("City not found");
      setWeatherData(null);
    }
  };

  const handleChange = (e) => {
    setCity(e.target.value);
    setWeatherData(null);
  };

  return (
    <div className="main-container">
      <div className="weather-container">
      <h1>Weather Report</h1>
        <form onSubmit={handleSubmit}>
          <label htmlFor="city">Enter City Name:
          <input
            type="text"
            id="city"
            value={city}
            required
            onChange={handleChange}
          />
          </label>
          <button type="submit">Get Weather</button>
        </form>
        <h2>Weather Description</h2>
        {weatherData && (
          <div className="weather-description">{weatherData}</div>
        )}
        {error && <div className="error-message">{error}</div>}
      </div>
    </div>
  );
}

export default WeatherData;
