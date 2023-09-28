package creational.farm;

public class Farm {
    private static Farm farm;
    private String name;

    private Farm() {
    }
    // Singletone, initialization of the object is done only once
    // and only when it is needed
    // It will use the same object every time, without creating a new one
    public static Farm getInstance() {
        if (farm == null) {
            farm = new Farm();
        }
        return farm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
