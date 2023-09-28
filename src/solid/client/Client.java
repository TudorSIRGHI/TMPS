package solid.client;

public class Client {
    private String name;
    private int numberOfTasks;
    private int income;

    public Client(String name, int numberOfTasks, int income) {
        this.name = name;
        this.numberOfTasks = numberOfTasks;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfTasks(int numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}

