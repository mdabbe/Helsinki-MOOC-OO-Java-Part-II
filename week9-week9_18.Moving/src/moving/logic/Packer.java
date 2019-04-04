package moving.logic;

import moving.domain.Box;
import moving.domain.Thing;

import java.util.ArrayList;
import java.util.List;

public class Packer {
    private int boxesVolume;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }


    public List<Box> packThings(List<Thing> things) {
        ArrayList<Box> boxes = new ArrayList<Box>();
        int boxNumber = 0;
        boxes.add(boxNumber, new Box(boxesVolume));
        for (Thing thing : things) {
            if (boxes.get(boxNumber).getVolume() + thing.getVolume() < boxesVolume) {
                boxes.get(boxNumber).addThing(thing);
            } else {
                boxNumber++;
                boxes.add(boxNumber, new Box(boxesVolume));
                boxes.get(boxNumber).addThing(thing);
            }
        }
        return boxes;
    }
}
