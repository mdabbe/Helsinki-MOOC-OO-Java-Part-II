import java.util.HashMap;
import java.util.List;

public class Jumper implements Comparable<Jumper> {
    private String name;
    private HashMap<Integer, Integer> jumps;
    private int points;

    public Jumper(String name) {
        this.name = name;
        this.jumps = new HashMap<Integer, Integer>();
        this.points = 0;
    }

    public int getJump(int round) {
        return jumps.get(round);
    }

    public void addPoints(List<Integer> votes) {
        for (int i = 1; i < 4; i++) {
            this.points += votes.get(i);
        }
    }

    public void addJump(int round, int jump) {
        this.points += jump;
        this.jumps.put(round, jump);
    }

    public int compareTo(Jumper that) {
        return that.points - this.points;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public String toString() {
        return this.name + " (" + this.points + " points)";
    }

    public String jumps() {
        String j = "jump lengths: ";
        for (int jump : jumps.values()) {
            j = j + jump + "m, ";
        }
        j = j.substring(0, j.length() - 2);
        return j;
    }
}
