package moving.domain;

import java.util.ArrayList;

public class Box implements Thing{
    private int maximumCapacity;
    private ArrayList<Thing> things;

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.things = new ArrayList<Thing>();
    }

    public boolean addThing(Thing thing) {
        if (this.getVolume() + thing.getVolume() > maximumCapacity) {
            return false;
        } else {
            things.add(thing);
            return true;
        }
    }


    @Override
    public int getVolume() {
        int volume = 0;
        for (Thing thing  : things) {
            volume += thing.getVolume();
        }
        return volume;
    }

//    public String toStrign() {
//        String boxContents = "";
//        for (Thing thing : things) {
//            boxContents+= thing + "\n";
//        }
//        return boxContents;
//    }
}
