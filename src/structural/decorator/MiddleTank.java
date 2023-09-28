package structural.decorator;

public class MiddleTank extends TankDecorator {
    private int addSpeed;

    public MiddleTank(Tank c, int addSpeed) {
        super(c);
        this.addSpeed = addSpeed;
    }

    public int getAddSpeed() {
        return addSpeed;
    }

    public void setAddSpeed(int addSpeed) {
        this.addSpeed = addSpeed;
    }

    @Override
    public int speed() {
        return super.speed() + getAddSpeed();
    }
}
