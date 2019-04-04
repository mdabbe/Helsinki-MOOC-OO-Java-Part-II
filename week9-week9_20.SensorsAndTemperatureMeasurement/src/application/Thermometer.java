package application;

public class Thermometer implements Sensor {
    private boolean isOn = false;

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void on() {
        this.isOn = true;
    }

    @Override
    public void off() {
        this.isOn = false;
    }

    @Override
    public int measure() {
        if (isOn) {
            return (int) (Math.random() * 60) -30;
        } else throw new IllegalStateException();
    }
}
