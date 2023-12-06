public class WeatherData {
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public WeatherData() {
        
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getPressure() {
        return pressure;
    }
}
