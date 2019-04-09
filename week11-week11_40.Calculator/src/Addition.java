import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addition implements ActionListener {
    private Calculator calculator;
    private JTextField textField;
    private JTextField displayField;
    private JButton button;

    public Addition(Calculator calculator, JTextField textField, JTextField displayField, JButton button) {
        this.calculator = calculator;
        this.textField = textField;
        this.displayField = displayField;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setEnabled(true);
        try {
            calculator.add(Integer.parseInt(textField.getText()));
            displayField.setText(Integer.toString(calculator.getNumber()));
            textField.setText("");
        } catch (NumberFormatException ex) {
            textField.setText("");
        }
    }
}
