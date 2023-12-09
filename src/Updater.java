import java.util.ArrayList;

public class Updater implements Observer {
    private ArrayList<WeatherDataCentral> subscribers = new ArrayList<WeatherDataCentral>();

    public Updater() {

    }

    public void addSubscriber(WeatherDataCentral subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(int index) {
        subscribers.remove(index);
    }

    public void clearSubescriberList() {
        subscribers.clear();
    }

    public void sendUpdate(WeatherData data) {
        for(int i = 0; i < subscribers.size(); i++) {
            subscribers.get(i).setData(data);
        }
    }
}
