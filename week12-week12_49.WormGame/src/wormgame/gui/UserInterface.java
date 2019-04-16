package wormgame.gui;

import wormgame.game.WormGame;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable {

    private JFrame frame;
    private WormGame game;
    private int sideLength;
    private DrawingBoard board;

    public UserInterface(WormGame game, int sideLength) {
        this.game = game;
        this.sideLength = sideLength;
    }

    @Override
    public void run() {
        frame = new JFrame("Worm Game");
        int width = (game.getWidth() + 1) * sideLength + 10;
        int height = (game.getHeight() + 2) * sideLength + 10;

        frame.setPreferredSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        this.board = new DrawingBoard(game, 10);
        container.add(board);
        KeyboardListener listener = new KeyboardListener(game.getWorm());
        frame.addKeyListener(listener);
        // Create drawing board first which then is added into container-object.
        // After this, create keyboard listener which is added into frame-object
    }

    public Updatable getUpdatable() {
        return board;
    }


    public JFrame getFrame() {
        return frame;
    }
}
