package models;
public class WeatherData {
    private float minTemp;
    private float maxTemp;
    private float humidity;
    private float pressure;

    public WeatherData(float minTemp, float maxTemp, float humidity, float pressure) {
    	setMinTemp(minTemp);
    	setMaxTemp(maxTemp);
        setHumidity(humidity);
        setPressure(pressure);
    }

    public WeatherData() {
        
    }

    public void setMinTemp(float minTemp) {
    	this.minTemp = minTemp;
    }
    
    public float getMinTemp() {
    	return minTemp;
    }
    
    public void setMaxTemp(float maxTemp) {
    	this.maxTemp = maxTemp;
    }
    
    public float getMaxTemp() {
    	return maxTemp;
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
    
    public float getAverageTemp() {
    	return (maxTemp+minTemp)/2;
    }
}
