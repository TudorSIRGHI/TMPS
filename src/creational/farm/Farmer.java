package creational.farm;

import creational.work.Work;

import java.util.ArrayList;
import java.util.List;

public class Farmer implements Cloneable {
    private List<String> work;
    private String name;
    private int salary;
    private Farm farm;

    public Farmer(FarmerBuilder builder) {
        this.work = builder.work;
        this.name = builder.name;
        this.salary = builder.salary;
        this.farm = builder.farm1;
    }

    public void saveWork(Work work) {
        this.work.add(work.farmerWork());
    }

    public void deleteWork(Work work) {
        this.work.remove(work.farmerWork());
    }

    public List<String> getWork() {
        return work;
    }

    public String getName() {
        return name;
    }

    public Farm getFarm() {
        return farm;
    }

    public int getSalary() {
        return salary;
    }

    // Prototype pattern
    // Clone method
    // Extract from object all the data and create a new object
    // with the same data
    @Override
    public Object clone() {
        List<String> tempWork = new ArrayList<String>(this.getWork());
        String tempName = this.getName();
        int tempSalary = this.getSalary();
        Farm tempFarm = this.getFarm();
        return new FarmerBuilder()
                .setSalary(tempSalary)
                .setFarm1(tempFarm)
                .setWork(tempWork)
                .setName(tempName)
                .build();
    }

    // Builder pattern

    public static class FarmerBuilder {
        private List<String> work;
        private String name;
        private int salary;
        private Farm farm1;

        // List of parameters that are required to create an object
        public FarmerBuilder setName(String name) {
            this.name = name;
            return this;
        }
        // Setters for the parameters
        // Return this is used to return the object itself
        // and to continue the chain of methods
        public FarmerBuilder setSalary(int salary) {
            this.salary = salary;
            return this;
        }

        public FarmerBuilder setWork(List<String> work) {
            this.work = work;
            return this;
        }

        public FarmerBuilder setFarm1(Farm farm1) {
            this.farm1 = farm1;
            return this;
        }

        // Functions that is used to set the parameters and exit from constructor, it will return a new object, in our example a new Farmer with our new settings
        public Farmer build() {
            return new Farmer(this);
        }
    }
}
