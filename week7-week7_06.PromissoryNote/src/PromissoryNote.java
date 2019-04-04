import java.util.HashMap;

public class PromissoryNote {
    private HashMap<String, Double> note;

    public PromissoryNote() {
        this.note = new HashMap<String, Double>();
    }

    public void setLoan(String toWhom, double value) {
        this.note.put(toWhom,value);
    }

    public double howMuchIsTheDebt(String whose) {
        if (this.note.containsKey(whose)){
            return this.note.get(whose);
        }
        return 0;
    }

    public String stringCleaner(String s) {
        if (s == null) {
            return "";
        }
        return s.toLowerCase().trim();

    }

}
