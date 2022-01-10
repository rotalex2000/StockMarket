import java.util.ArrayList;

public class StockMarket {

    private final ArrayList<Currency> currencies = new ArrayList<>();

    private final ArrayList<Subscriber> createSubscribers = new ArrayList<>();
    private final ArrayList<Subscriber> updateSubscribers = new ArrayList<>();

    public void subscribeSubscriber(Subscriber subscriber, Action action) {
       if (action == Action.CREATE) {
           createSubscribers.add(subscriber);
       } else {
           updateSubscribers.add(subscriber);
       }
    }

    public void createCurrency(String name, double value) {
        Currency currency = new Currency(name, value);
        currencies.add(currency);
        notifySubscribers(createSubscribers, currency, Action.CREATE);
    }

    public void updateCurrency(String name, double value) {
        Currency currency = getCurrencyByName(name);
        assert currency != null;
        currency.setValue(value);
        notifySubscribers(updateSubscribers, currency, Action.UPDATE);
    }

    private void notifySubscribers(ArrayList<Subscriber> list, Currency currency, Action action) {
        for (Subscriber subscriber : list)
        {
            subscriber.notify(currency, action);
        }
    }

    private Currency getCurrencyByName(String name) {
        for (Currency currency : currencies) {
            if (currency != null && currency.getName().equals(name)) {
                return currency;
            }
        }
        return null;
    }
}
