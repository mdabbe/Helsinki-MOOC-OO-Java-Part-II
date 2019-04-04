package farmsimulator;

public class MilkingRobot {
    private BulkTank bulkTank;

    public MilkingRobot() {

    }

    public void milk(Milkable milkable) {
        if (bulkTank == null) {
            throw new IllegalStateException();
        } else {
            bulkTank.addToTank(milkable.milk());
        }
    }

    public BulkTank getBulkTank() {
        return bulkTank;
    }

    public void setBulkTank(BulkTank tank) {
        this.bulkTank = tank;
    }
}
