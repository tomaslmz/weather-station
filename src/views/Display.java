package views;

import models.WeatherData;


public interface Display {
    public WeatherData update(float minTemp, float maxTemp, float humidity, float pressure);
}
