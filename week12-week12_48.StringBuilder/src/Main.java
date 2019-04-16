
public class Main {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(build(t));
    }

    public static String build(int[] t) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n").append(" ");
        for (int i = 1; i <= t.length; i++) {
            sb.append(t[i-1]);
            if (i != t.length) {
                sb.append(", ");
            }
            if (i % 4 == 0 && i != t.length) sb.append("\n").append(" ");
        }
        sb.append("\n}");
        return sb.toString();
    }
}
