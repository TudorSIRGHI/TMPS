package structural.decorator;

public class GiantTank extends TankDecorator {

    private int addSpeed;

    public GiantTank(Tank c, int addSpeed) {
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
    public int speed(){
        return super.speed() + getAddSpeed();
    }
}
