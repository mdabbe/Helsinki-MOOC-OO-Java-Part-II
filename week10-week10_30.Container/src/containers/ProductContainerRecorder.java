package containers;

public class ProductContainerRecorder extends ProductContainer {
    private ContainerHistory containerHistory;

    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);
        super.addToTheContainer(initialVolume);
        this.containerHistory = new ContainerHistory();
        containerHistory.add(initialVolume);
    }

    public String history() {
        return containerHistory.toString();
    }
    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        containerHistory.add(super.getVolume());
    }
    @Override
    public double takeFromTheContainer(double amount) {
        double r = super.takeFromTheContainer(amount);
        containerHistory.add(super.getVolume());
        return r;

    }

    public void printAnalysis() {
        System.out.println("Product: " + super.getName() + "\n" +
                                   "History: " + this.history() + "\n" +
                                   "Greatest product amount: " + containerHistory.maxValue() + "\n" +
                                   "Smallest product amount: " + containerHistory.minValue() + "\n" +
                                   "Average: " + containerHistory.average() + "\n" +
                                   "Greatest change: " + containerHistory.greatestFluctuation() + "\n" +
                                   "Variance: " + containerHistory.variance() + "\n");
    }
}
