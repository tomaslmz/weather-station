public class WeatherDataCentral {
    private WeatherData data;

    public WeatherDataCentral(WeatherData data) {
        setData(data);
    }

    public void setData(WeatherData data) {
        this.data = data;
    }

    public WeatherData getData() {
        return data;
    }
}
