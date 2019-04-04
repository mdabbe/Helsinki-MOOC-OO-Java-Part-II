package farmsimulator;

public class BulkTank {
    private double capacity;
    private double volume;

    public BulkTank() {
        capacity = 2000;
        volume = 0.0;
    }
    public BulkTank(double capacity) {
        this.capacity = capacity;
        this.volume = 0.0;
    }
    public double getCapacity() {
        return capacity;
    }
    public double getVolume() {
        return volume;
    }
    public double howMuchFreeSpace() {
        return capacity - volume;
    }
    public void addToTank(double amount) {
        volume+= amount;
        if (volume > capacity) {
            volume = capacity;
        }
    }
    public double getFromTank(double amount) {
        if (volume > amount) {
            volume -= amount;
            return amount;
        } else {
            double p = volume;
            volume = 0;
            return p;
        }
    }

    public String toString() {
        return Math.ceil(volume) + "/" + Math.ceil(capacity);
    }

}
