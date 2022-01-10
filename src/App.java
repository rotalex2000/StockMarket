public class App {
    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Subscriber alex = new Subscriber("Alex");
        Subscriber maria = new Subscriber("Maria");

        stockMarket.subscribeSubscriber(alex, Action.CREATE);
        stockMarket.subscribeSubscriber(alex, Action.UPDATE);
        stockMarket.subscribeSubscriber(maria, Action.UPDATE);

        stockMarket.createCurrency("EUR", 4.9);
        stockMarket.updateCurrency("EUR", 5.1);
    }
}