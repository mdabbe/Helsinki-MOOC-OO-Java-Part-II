
import javax.swing.*;
import java.awt.*;

public class GraphicCalculator implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        Calculator calculator = new Calculator();
        container.setLayout(new GridLayout(3,1));
        JTextField displayField = new JTextField();
        displayField.setText("0");
        displayField.setEnabled(false);
        container.add(displayField);
        JTextField textField = new JTextField();
        container.add(textField);
        JPanel panel = new JPanel(new GridLayout(1,3));
        JButton buttonPlus = new JButton("+");
        JButton buttonMinus = new JButton("-");
        JButton buttonZ = new JButton("Z");
        buttonZ.setEnabled(false);
        buttonPlus.addActionListener(new Addition(calculator, textField, displayField, buttonZ));
        buttonMinus.addActionListener(new Substraction(calculator, textField, displayField, buttonZ));
        buttonZ.addActionListener(new Clear(calculator, displayField, textField, buttonZ));
        panel.add(buttonPlus);
        panel.add(buttonMinus);
        panel.add(buttonZ);
        container.add(panel);
    }



    public JFrame getFrame() {
        return frame;
    }
}
