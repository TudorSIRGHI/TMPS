package solid.client;

public class ExpensiveClient extends Client {
    private int priceIncrease;

    public ExpensiveClient(String name, int numberOfTasks, int income, int priceIncrease) {
        super(name, numberOfTasks, income);
        this.priceIncrease = priceIncrease;
    }

    public int getPriceIncrease() {
        return priceIncrease;
    }

    public void setPriceIncrease(int priceIncrease) {
        this.priceIncrease = priceIncrease;
    }
}
