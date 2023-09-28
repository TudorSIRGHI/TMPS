package structural.decorator;

public class TankDecorator implements Tank {
    protected Tank tank;

    public TankDecorator(Tank c) {
        this.tank = c;
    }

    @Override
    public void shot() {
        System.out.println("Shot");
    }

    @Override
    public int speed() {
        return this.tank.speed();
    }

}
