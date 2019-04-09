import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clear implements ActionListener {
    private Calculator calculator;
    private JTextField displayField;
    private JTextField textField;
    private JButton button;

    public Clear(Calculator calculator, JTextField displayField, JTextField textField, JButton button) {
        this.calculator = calculator;
        this.displayField = displayField;
        this.textField = textField;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        calculator.clear();
        displayField.setText("0");
        textField.setText("");
        button.setEnabled(false);
    }
}
