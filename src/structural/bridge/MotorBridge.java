package structural.bridge;

public abstract class MotorBridge {
    protected Motor motor;

    public MotorBridge(Motor motor){
        this.motor = motor;
    }

    abstract public int addVolume();
}
