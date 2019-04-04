package farmsimulator;

import java.util.Collection;

public class Barn {
    private BulkTank tank;
    private MilkingRobot milkingRobot;

    public Barn(BulkTank tank) {
        this.tank = tank;
    }
    public BulkTank getBulkTank() {
        return this.tank;
    }

    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.milkingRobot = milkingRobot;
        this.milkingRobot.setBulkTank(tank);
    }

    public void takeCareOf(Cow cow) {
        if (milkingRobot == null) {
            throw new IllegalStateException();
        } else {
            milkingRobot.milk(cow);
        }
    }

    public void takeCareOf(Collection<Cow> cows) {
        if (milkingRobot == null) {
            throw new IllegalStateException();
        } else {
            for (Cow cow : cows) {
                takeCareOf(cow);
            }
        }
    }

    public String toString() {
        return "Barn: " + tank.toString();
    }
}
