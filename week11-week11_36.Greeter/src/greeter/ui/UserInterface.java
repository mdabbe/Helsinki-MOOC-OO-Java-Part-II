package greeter.ui;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable {

    private JFrame frame;
    

    @Override
    public void run() {
        frame = new JFrame("Swing on");
        frame.setPreferredSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.add(new JLabel("Hi!"));
    }

    public JFrame getFrame() {
        return frame;
    }
}
