import farmsimulator.Barn;
import farmsimulator.BulkTank;
import farmsimulator.Cow;
import farmsimulator.Farm;

public class Main {

    public static void main(String [] arg) {
        Farm farm = new Farm("Esko", new Barn(new BulkTank()));

        farm.addCow(new Cow());
        farm.addCow(new Cow());
        farm.addCow(new Cow());

        farm.liveHour();
        farm.liveHour();
        System.out.println(farm);


    }
}

