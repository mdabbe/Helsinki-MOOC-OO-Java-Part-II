package wormgame.gui;

import wormgame.domain.Piece;
import wormgame.game.WormGame;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DrawingBoard extends JPanel implements Updatable {
    private WormGame game;
    private int pieceLength;

    public DrawingBoard(WormGame game, int pieceLength) {
        this.game = game;
        this.pieceLength = pieceLength;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(game.getApple().getX() * pieceLength, game.getApple().getY() * pieceLength, pieceLength, pieceLength);
        g.setColor(Color.BLACK);
        List<Piece> wormPieces = game.getWorm().getPieces();
        for (Piece piece : wormPieces) {
            g.fill3DRect(piece.getX() * pieceLength,piece.getY() * pieceLength, pieceLength, pieceLength, true);
        }
    }

    @Override
    public void update() {
        repaint();
    }
}
