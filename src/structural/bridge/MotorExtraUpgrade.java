package structural.bridge;

public class MotorExtraUpgrade extends MotorBridge {
    private int volume;
    public MotorExtraUpgrade(Motor c, int volume) {
        super(c);
        this.volume = volume;
    }

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