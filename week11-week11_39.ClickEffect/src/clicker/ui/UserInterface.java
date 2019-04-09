package clicker.ui;

import clicker.applicationlogic.PersonalCalculator;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private PersonalCalculator calculator;

    public UserInterface(PersonalCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);
        JLabel label = new JLabel("0");
        JButton button = new JButton("Click!");
        ClickListener clickListener = new ClickListener(calculator, label);
        button.addActionListener(clickListener);
        container.add(label, BorderLayout.WEST);
        container.add(button, BorderLayout.SOUTH);

    }

    public JFrame getFrame() {
        return frame;
    }
}
