import java.util.ArrayList;

public class Suitcase {
    private ArrayList<Thing> things;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
    }

    public void addThing(Thing thing) {
        if (maxWeight >= (this.totalWeight() + thing.getWeight())) {
            this.things.add(thing);
        }
    }

    public String toString(){
        if (this.things.size()==0) {
            return "empty (0 kg)";
        } else if (this.things.size() == 1) {
             return this.things.size() + " thing (" + this.totalWeight() + " kg)";
        } else {
            return this.things.size() + " things (" + this.totalWeight() + " kg)";
        }


    }
    public int totalWeight(){
        int totalWeight = 0;
        for (Thing t : things) {
            totalWeight+= t.getWeight();
        }
        return totalWeight;
    }

    public void printThings(){
        for (Thing thing : things) {
            System.out.println(thing);
        }
    }

    public Thing heaviestThing() {
        if (this.things.size() == 0) {
            return null;
        } else {
            int indexOfHeaviest = 0;
            int weightOfHeaviest = this.things.get(0).getWeight();
            for (int i = 0; i < things.size(); i++) {
                if (things.get(i).getWeight() > weightOfHeaviest) {
                    weightOfHeaviest = things.get(i).getWeight();
                    indexOfHeaviest = i;
                }
            }
            return things.get(indexOfHeaviest);
        }
    }


}
