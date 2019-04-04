import java.util.ArrayList;

public class Box implements ToBeStored {
    private ArrayList<ToBeStored> things;
    private double maxWeight;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<ToBeStored>();
    }

    public void add(ToBeStored thing) {
        if (this.weight() + thing.weight() <= maxWeight) {
            things.add(thing);
        }
    }

    public double weight() {
        double weight = 0;
        for (ToBeStored thing : things) {
            weight += thing.weight();
        }
        return weight;
    }

    public String toString() {
        return "Box: " + things.size() + " things, total weight " + this.weight() + " kg";
    }
}
