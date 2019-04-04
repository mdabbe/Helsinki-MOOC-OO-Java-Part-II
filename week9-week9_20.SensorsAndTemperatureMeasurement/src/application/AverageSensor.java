package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private ArrayList<Sensor> sensors;
    private List<Integer> measures;

    public AverageSensor() {
        this.sensors = new ArrayList<Sensor>();
        this.measures = new ArrayList<Integer>();
    }

    public void addSensor(Sensor additional) {
        sensors.add(additional);
    }

    public List<Integer> readings() {
        return measures;
    }




    @Override
    public boolean isOn() {
        boolean isOn = true;
        for (Sensor sensor : sensors) {
            if (!sensor.isOn()) {
                isOn = false;
                break;
            }
        }
        return isOn;
    }

    @Override
    public void on() {
        for (Sensor sensor : sensors) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : sensors) {
            sensor.off();
        }
    }

    @Override
    public int measure() {
        if (!isOn() || sensors.isEmpty()) {
            throw new IllegalStateException();
        }
        int sum = 0;
        for (Sensor sensor : sensors) {
            sum += sensor.measure();
        }
        int measure = sum / sensors.size();
        measures.add(measure);
        return measure;
    }
}
