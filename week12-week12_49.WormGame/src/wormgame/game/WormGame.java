package wormgame.game;

import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;
    private Random random;

    public WormGame(int width, int height) {
        super(1000, null);
        this.random = new Random();
        this.width = width;
        this.height = height;
        this.continues = true;
        this.worm = new Worm(width/2, height/2, Direction.DOWN);
        this.apple = createApple();
        addActionListener(this);
        setInitialDelay(2000);

    }

    public Worm getWorm() {
        return this.worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return this.apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }


    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Apple createApple() {
        int xWorm = worm.head().getX();
        int yWorm = worm.head().getY();
        int x,y;
        do {
            x = random.nextInt(width);
            y = random.nextInt(height);
        } while ((x == xWorm && y == yWorm) || (x <= 0 || y <= 0));
        return new Apple(x,y);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (continues) {
            worm.move();
            int wormX = worm.head().getX();
            int wormY = worm.head().getY();
            if(wormX == width || wormY == height || wormX == 0 || wormY == 0) {
                continues = false;
            }
            if (worm.runsInto(apple)) {
                worm.grow();
                setApple(createApple());
            }
            if (worm.runsIntoItself()) {
                continues = false;
            }
            updatable.update();
            if (worm != null) {
                super.setDelay(1000 / worm.getLength());
            }
        }

    }

}
