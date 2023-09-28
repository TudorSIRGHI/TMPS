package behavioral.strategy;

public class Grain {

    private String name;
    private int quantity;

    public Grain(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

}
