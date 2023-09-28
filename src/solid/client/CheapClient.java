package solid.client;
//Liskov Substitution Principle We can substitute CheapProstitute with Prostitute
public class CheapClient extends Client {
    private int priceReduction;

    public CheapClient(String name, int numberOfTasks, int income, int priceReduction) {
        super(name, numberOfTasks, income);
        this.priceReduction = priceReduction;
    }

    public int getPriceReduction() {
        return priceReduction;
    }

    public void setPriceReduction(int priceReduction) {
        this.priceReduction = priceReduction;
    }
}
