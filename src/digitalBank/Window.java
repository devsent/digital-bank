package digitalBank;

import javax.swing.*;

public class Window {

    public void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(
                null,
                message,
                title,
                messageType
        );
    }
    public String inputDialog (String message, String title, int messageType) {
        return JOptionPane.showInputDialog(
                null,
                message,
                title,
                messageType
        );
    }

    public int confirmDialog (String message, String title, int messageType) {
        return JOptionPane.showConfirmDialog(
                null,
                message,
                title,
                messageType
        );
    }

    public int optionDialog(
            String message,
            String title,
            int messageType,
            int optionType,
            String option1,
            String option2) {

        Object[] options = {option1, option2};

        return JOptionPane.showOptionDialog(
                null,
                message,
                title,
                optionType,
                messageType,
                null,
                options,
                options[0]
        );
    }
}
