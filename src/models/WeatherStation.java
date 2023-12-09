package models;

public class WeatherStation {
    private WeatherData weatherData;
    
    public WeatherStation(WeatherData weatherData) {
        setWeatherData(weatherData);
    }

    public WeatherStation() {

    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }
}
