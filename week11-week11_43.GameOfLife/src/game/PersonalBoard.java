package game;

import gameoflife.GameOfLifeBoard;

import java.util.Random;

public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double v) {
        Random random = new Random();
        for (boolean[] row : getBoard()) {
            for (int i = 0; i < row.length; i++) {
                row[i] =  random.nextDouble() < v;
            }
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if (onBoard(x,y)) {
            return getBoard()[x][y];
        }
        return false;
    }

    @Override
    public void turnToLiving(int x, int y) {
        if (onBoard(x,y)) {
            getBoard()[x][y] = true;
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        if (onBoard(x,y)) {
            getBoard()[x][y] = false;
        }
    }


    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int neighbours = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (isAlive(i,j)) neighbours++;
            }
        }
        if (isAlive(x,y)) neighbours--;
        return neighbours;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        if (livingNeighbours == 3) {
            if (!isAlive(x,y)) turnToLiving(x,y);
        } else if (livingNeighbours > 3 || livingNeighbours < 2) {
            turnToDead(x,y);
        }


    }

    public boolean onBoard(int x, int y) {
        if (x >= 0 && y >= 0) {
            if (x < getWidth() && y < getHeight()) {
                return true;
            }
        }
        return false;
    }
}
