package views;

import models.WeatherData;


public interface Display {
    public WeatherData update(float temperature, float humidity, float pressure);
}
