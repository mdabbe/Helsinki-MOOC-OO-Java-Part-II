import java.util.*;

public class Simulator {
    private Scanner reader;
    private List<Jumper> jumpers;
    private HashMap<Jumper, List<Integer>> votes;

    public Simulator(Scanner reader) {
        this.reader = reader;
        this.jumpers = new ArrayList<Jumper>();
        this.votes = new HashMap<Jumper, List<Integer>>();
    }

    public void start() {
        System.out.println("Kumpula ski jumping week\n");
        addParticipants();
        tournament();
        tournamentResult();

    }
    public void addParticipants() {
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        String input;
        while (true) {
            System.out.print("  Participant name: ");
            input = reader.nextLine();
            if (input.isEmpty()) {
                break;
            } else {
                jumpers.add(new Jumper(input));
            }
        }
    }
    public void tournament() {
        System.out.println("The tournament begins!\n");
        String input;
        int round = 1;
        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            input = reader.nextLine();
            if (!input.equals("jump")) {
                System.out.println("Thanks!");
                break;
            } else {
                round(round);
                round++;
            }
        }
    }

    public void round(int round) {
        System.out.println("\nRound " + round + "\n");
        jumpingOrder();
        for (Jumper jumper : jumpers) {
            jump(jumper, round, jumpLength(), judgeVotes());
        }
        System.out.println("Results of round " + round);
        Collections.sort(jumpers);
        roundResults(round);
    }

    public void jump(Jumper jumper,int round, int jump, List<Integer> notes) {
        jumper.addJump(round, jump);
        jumper.addPoints(notes);
        votes.put(jumper, notes);
    }
    public void roundResults(int round) {
        for (Jumper jumper : jumpers) {
            System.out.println("  " + jumper.getName());
            System.out.println("    length: " + jumper.getJump(round));
            System.out.println("    judge votes: " + votes.get(jumper).toString());
        }
    }

    public void tournamentResult() {
        System.out.println("\nTournament results:\n" +
                            "Position    Name");
        int position = 1;
        Collections.sort(jumpers);
        for (Jumper jumper : jumpers) {
            System.out.print(position + "           ");
            System.out.println(jumper);
            System.out.print("            ");
            System.out.println(jumper.jumps());
            position++;
        }
    }

    public void jumpingOrder() {
        Collections.sort(jumpers);
        Collections.reverse(jumpers);
        int i = 1;
        System.out.println("Jumping order:");
        for (Jumper jumper : jumpers) {
            System.out.println("  " + i +". " + jumper);
            i++;
        }
        System.out.println();
    }





    public int jumpLength() {
        return (int) ((Math.random() * 60) + 60);
    }

    public List<Integer> judgeVotes() {
        List<Integer> votes = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            votes.add((int) ((Math.random() * 10) + 10));
        }
        Collections.sort(votes);
        return votes;
    }



}
