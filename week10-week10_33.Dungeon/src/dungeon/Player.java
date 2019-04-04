package dungeon;

public class Player{
    private int x;
    private int y;
    private int height;
    private int length;

    public Player(int height, int length) {
        this.x = 0;
        this.y = 0;
        this.height = height - 1;
        this.length = length - 1;
    }

    public void move(char command) {
        switch (command) {
            case 'w':
                if (y > 0) {
                    y--;
                    break;
                }
            case 's':
                if (y < height) {
                    y++;
                    break;
                }

            case 'd':
                if (x < length) {
                    x++;
                    break;
                }
            case 'a':
                if (x > 0) {
                    x--;
                    break;
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
        return "@ " + x + " " + y;
    }
}
