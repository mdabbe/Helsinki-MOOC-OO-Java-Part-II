package boxes;

public class OneThingBox extends Box {
    private Thing thing;

    public OneThingBox() {
        thing = null;
    }

    @Override
    public void add(Thing thing) {
        if (this.thing == null) {
            this.thing = thing;
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if (this.thing == null) {
            return false;
        } else {
            return this.thing.equals(thing);
        }
    }
}
