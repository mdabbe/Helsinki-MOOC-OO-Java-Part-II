package movingfigure;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CompoundFigure extends Figure {
    private List<Figure> figureList;

    public CompoundFigure() {
        super(0,0);
        this.figureList = new ArrayList<Figure>();
    }

    public void add(Figure f) {
        figureList.add(f);
    }

    @Override
    public void move(int dx, int dy) {
        for (Figure figure : figureList) {
            figure.move(dx,dy);
        }
    }

    @Override
    public void draw(Graphics graphics) {
        for (Figure figure : figureList) {
            figure.draw(graphics);
        }
    }
}
