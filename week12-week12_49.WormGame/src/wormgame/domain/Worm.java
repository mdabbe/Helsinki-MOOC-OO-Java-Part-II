package wormgame.domain;

import wormgame.Direction;

import java.util.ArrayList;
import java.util.List;

public class Worm {
    private int x,  y;
    private Direction direction;
    private List<Piece> pieces;
    private boolean grow;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.x = originalX;
        this.y = originalY;
        this.grow = true;
        this.direction = originalDirection;
        this.pieces = new ArrayList<Piece>();
        this.pieces.add(new Piece(originalX, originalY));
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    public boolean runsIntoItself() {
        for (int i = 0; i < pieces.size() - 1; i++) {
            if (head().runsInto(pieces.get(i))) {
                return true;
            }
        }
        return false;
    }
    public Piece head() {
        return this.pieces.get(pieces.size() - 1);
    }

    public boolean runsInto(Piece piece) {
        for (Piece p : this.pieces) {
            if (p.runsInto(piece)) {
                return true;
            }
        }
        return false;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void move() {
        Piece head = pieces.get(pieces.size()-1);
        int x = head.getX(), y = head.getY();
        switch (direction) {
            case UP:
                pieces.add(new Piece(x, y-1));
                break;
            case DOWN:
                pieces.add(new Piece(x, y+1));
                break;
            case LEFT:
                pieces.add(new Piece(x-1, y));
                break;
            case RIGHT:
                pieces.add(new Piece(x+1, y));
                break;
        }
        if (!grow) {
            pieces.remove(0);
        }
        if (pieces.size() >= 3) {
            grow = false;
        }
    }

    public void grow() {
        grow = true;

    }

    public int getLength() {
        return pieces.size();
    }
}
