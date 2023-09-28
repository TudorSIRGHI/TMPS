package creational;

import creational.farm.Farm;
import creational.farm.Farmer;
import creational.work.Work;
import creational.work.ServiceFactory;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Farm farm = Farm.getInstance();
        farm.setName("Vezde Travka");
        Farm farm1 = Farm.getInstance();
        System.out.println("Farm name is " + farm1.getName());

        // Builder pattern
        // Calling a new farmer with function builder from Farmer class
        // Here we are setting the parameters for the farmer
        Farmer farmer = new Farmer.FarmerBuilder()
                .setWork(new ArrayList<>())
                .setSalary(1200)
                .setFarm1(farm)
                .setName("Colea")
                .build();

        // Factory pattern
        ServiceFactory serviceFactory = new ServiceFactory();
        Work dig = serviceFactory.setWork("Dig");
        Work leave = serviceFactory.setWork("Leave");
        Work sow = serviceFactory.setWork("Sow");
        farmer.saveWork(sow);
        farmer.saveWork(leave);

        // All the parameters are the same, but the object is different, in simple words, cloning
        Farmer farmer2 = (Farmer) farmer.clone();
        Farmer farmer3 = (Farmer) farmer.clone();
        farmer3.saveWork(dig);
        Farmer farmer4 = (Farmer) farmer.clone();
        farmer4.deleteWork(dig);

        farmer2.getWork().forEach(s -> System.out.print(s + " "));
        System.out.println();
        farmer3.getWork().forEach(s -> System.out.print(s + " "));
        System.out.println();
        farmer4.getWork().forEach(s -> System.out.print(s + " "));
    }
}
