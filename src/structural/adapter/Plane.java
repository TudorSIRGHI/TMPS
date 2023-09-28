package structural.adapter;

import structural.bridge.MotorBridge;

public class Plane implements PlaneAction {
    private MotorBridge motorBridge;
    private int speed;

    public Plane(MotorBridge motorBridge, int speed) {
        this.motorBridge = motorBridge;
        this.speed = speed;
    }

    @Override
    public void fly() {
        System.out.println("It can fly very fast");
    }

}
