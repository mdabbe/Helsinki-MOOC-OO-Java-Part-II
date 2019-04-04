package containers;


import java.util.ArrayList;
import java.util.List;

public class ContainerHistory {
    private List<Double> history;

    public ContainerHistory() {
        this.history = new ArrayList<Double>();
    }

    public void add(double situation) {
        history.add(situation);
    }

    public void reset() {
        history.clear();
    }

    public String toString() {
        return history.toString();
    }

    public double maxValue() {
        if (history.isEmpty()) { return 0; }
        double max = history.get(0);
        for (double d : history) {
            max = d > max ? d : max;
        }
        return max;
    }

    public double minValue() {
        if (history.isEmpty()) {
            return 0;
        }
        double min = history.get(0);
        for (double d : history) {
            min = d < min ? d : min;
        }
        return min;
    }

    public double average() {
        if (history.isEmpty()) {
            return 0;
        } else {
            int size = history.size();
            double total = 0;
            for (double d : history) {
                total += d;
            }
            return total / (double) size;
        }
    }

    public double greatestFluctuation() {
        if (history.isEmpty() || history.size() == 1) {
            return 0;
        } else {
            double greatestFluctuation = Math.abs( history.get(0) - history.get(1));
            for (int i = 0; i < history.size() - 1; i++) {
                double compared = Math.abs( history.get(i) - history.get(i+1));
                greatestFluctuation = greatestFluctuation < compared ? compared : greatestFluctuation;
            }
            return greatestFluctuation;
        }
    }

    public double variance() {
        if (history.isEmpty() || history.size() == 1) {
            return 0;
        } else {
            double sum = 0;
            double averageOfList = this.average();
            for (double item : history) {
                sum += Math.pow((item - averageOfList), 2);
            }
            return sum / (history.size() - 1);
        }
    }

}
