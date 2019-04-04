package dungeon;

import java.util.Random;

public class Vampire{
    private int x;
    private int y;
    private int height;
    private int length;
    private Random random;

    public Vampire(int height, int length) {
        this.random = new Random();
        this.height = height - 1;
        this.length = length - 1;
        do {
            x = random.nextInt(this.length);
            y = random.nextInt(this.height);
        } while (x == 0 && y == 0);
    }


    public void move() {
        while (true) {
            int command = random.nextInt(4);
            switch (command) {
                case 0 :
                    if (y > 0){
                        y--;
                        return;
                    }
                case 1 :
                    if (y < height) {
                        y++;
                        return;
                    }
                case 2 :
                    if (x < length) {
                        x++;
                        return;
                    }
                case 3 :
                    if (x > 0) {
                        x--;
                        return;
                    }
            }
        }

    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    public String toString() {

        return "v " + x + " " + y;

     }
}
