package structural.bridge;

public class MotorUpgrade extends MotorBridge {
    public MotorUpgrade(Motor c, int volume) {
        super(c);
        this.volume = volume;
    }

    private int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int addVolume() {
        return motor.volume() + volume;
    }

}