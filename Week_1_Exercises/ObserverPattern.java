import java.util.ArrayList;
import java.util.List;

interface Stock {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

 class StockMarket implements Stock {
    private List<Observer> observers;
    private double price;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
}

 interface Observer {
    void update(double price);
}

class MobileApp implements Observer {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(double price) {
        System.out.println(appName + " received stock price update: " + price);
    }
}
 class WebApp implements Observer {
    private String appName;

    public WebApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(double price) {
        System.out.println(appName + " received stock price update: " + price);
    }
}

 class ObserverPattern {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp1 = new MobileApp("MobileApp1");
        Observer mobileApp2 = new MobileApp("MobileApp2");
        Observer webApp = new WebApp("WebApp");

        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);
        stockMarket.registerObserver(webApp);

        System.out.println("Setting stock price to 100.0");
        stockMarket.setPrice(100.0);

        System.out.println("\nSetting stock price to 200.0");
        stockMarket.setPrice(200.0);

        stockMarket.removeObserver(mobileApp2);

        System.out.println("\nSetting stock price to 300.0");
        stockMarket.setPrice(300.0);
    }
}
