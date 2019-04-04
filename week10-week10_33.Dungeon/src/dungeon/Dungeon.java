package dungeon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Dungeon {
    private char[][] board;
    private Player player;
    private int moves;
    private List<Vampire> vampires;
    private boolean vampiresMove;
    private Scanner scanner;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.board = new char[height][length];
        this.vampiresMove = vampiresMove;
        this.moves = moves;
        this.scanner = new Scanner(System.in);
        this.player = new Player(height, length);
        this.board[0][0] = '@';
        this.vampires = new ArrayList<Vampire>();
        this.createMobs(vampires, height, length);
    }

    public void createMobs(int vampiresNumber , int height, int length) {
        for (int i = 0; i < vampiresNumber; i++) {
            vampires.add(new Vampire(height, length));
        }

    }

    public void run() {
        while (moves > 0) {
            drawStatus();
            drawBoard();
            getInput();
            if (vampires.isEmpty()){
                System.out.println("YOU WIN");
                break;
            }
            moves--;
        }
        System.out.println("YOU LOSE");
    }


    public void getInput() {
        char[] commands = scanner.nextLine().toLowerCase().toCharArray();
        for (char command : commands) {
            player.move(command);
            if (vampiresMove) {
                for (Vampire vampire : vampires) {
                    vampire.move();
                }
            }
            killVampires();
        }

    }

    private void killVampires() {
        for (int i = 0; i < vampires.size(); i++) {
            if (vampires.get(i).getX() == player.getX() && vampires.get(i).getY() == player.getY()){
                vampires.remove(i);
                i--;
            }
        }
    }




    public void drawBoard() {
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        board[player.getY()][player.getX()] = '@';
        for (Vampire vampire : vampires) {
            board[vampire.getY()][vampire.getX()] = 'v';
        }
        for (char[] row : board) {
            for (char column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void drawStatus() {
        System.out.println(moves + "\n");
        System.out.println(player);
        for (Vampire vampire : vampires) {
            System.out.println(vampire);
        }
        System.out.println();
    }


}
