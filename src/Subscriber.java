public class Subscriber {

    private final String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void notify(Currency currency, Action action) {
        System.out.println("==========");
        System.out.println("Notification for " + this.name);
        if (action == Action.CREATE) {
            System.out.println("New currency: " + currency.getName() + " - " + currency.getValue());
        } else {
            System.out.println(currency.getName() + "'s value is now " + currency.getValue());
        }
    }
}
