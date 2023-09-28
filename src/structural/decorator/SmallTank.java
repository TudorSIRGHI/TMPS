package structural.decorator;

import structural.composite.GunBuilding;

public class SmallTank implements Tank {
    private String name;
    private int speed;
    private GunBuilding gunBuilding;

    public SmallTank(String name, int speed, GunBuilding gunBuilding) {
        this.name = name;
        this.speed = speed;
        this.gunBuilding = gunBuilding;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int speed() {
        return getSpeed() + gunBuilding.getPrice();
    }

    @Override
    public void shot() {
        System.out.println("Make a SHOT");
    }
}
