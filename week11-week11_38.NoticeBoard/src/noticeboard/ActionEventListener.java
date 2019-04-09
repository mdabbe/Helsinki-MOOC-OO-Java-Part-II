package noticeboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventListener implements ActionListener {
    private JTextField textField;
    private JLabel label;

    public ActionEventListener(JTextField textField, JLabel label) {
        this.textField = textField;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText(textField.getText());
        textField.setText("");
    }
}
