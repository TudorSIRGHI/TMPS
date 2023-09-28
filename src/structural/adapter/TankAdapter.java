package structural.adapter;

import structural.decorator.Tank;

public class TankAdapter implements PlaneAction {
    Tank tank;
    public TankAdapter(Tank tank) {
        this.tank = tank;
    }

    public void fly() {
        tank.shot();
    }
}
