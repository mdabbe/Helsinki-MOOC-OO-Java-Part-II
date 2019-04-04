package farmsimulator;

import java.util.ArrayList;
import java.util.List;

public class Farm implements Alive{
    private String owner;
    private Barn barn;
    private List<Cow> cows;

    public Farm(String owner,Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.cows = new ArrayList<Cow>();
    }

    public String getOwner() {
        return owner;
    }

    public void manageCows() {
        for (Cow cow : cows) {
            barn.takeCareOf(cow);
        }
    }
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.barn.installMilkingRobot(milkingRobot);
    }

    public void addCow(Cow cow) {
        cows.add(cow);
    }

    public String toString() {
        if (cows.isEmpty()) {
            return "Farm owner: " + this.owner + "\n" +
                    "Barn bulk tank: " + barn.getBulkTank() + "\n" +
                    "No cows.";
        } else {
            StringBuilder animals = new StringBuilder();
            for (Cow cow : cows) {
                animals.append("        ").append(cow).append("\n");
            }
            return "Farm owner: " + this.owner + "\n" +
                    "Barn bulk tank: " + barn.getBulkTank() + "\n" +
                    "Animals:\n" + animals.toString();
        }
    }

    @Override
    public void liveHour() {
        for (Cow cow : cows) {
            cow.liveHour();
        }
    }
}
