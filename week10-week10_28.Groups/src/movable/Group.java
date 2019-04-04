package movable;

import java.util.ArrayList;
import java.util.List;

public class Group implements Movable {
    private List<Movable> group;


    public Group() {
        this.group = new ArrayList<Movable>();
    }

    public void addToGroup(Movable movable) {
        group.add(movable);
    }
    @Override
    public void move(int dx, int dy) {
        for (Movable movable : group) {
            movable.move(dx,dy);
        }
    }

    public String toString() {
        String s = "";
        for (Movable movable : group) {
            s = s + movable + "\n";
        }
        return s;
    }
}
