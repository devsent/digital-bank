package digitalBank;

import javax.swing.*;

public class CurrentAccount extends Account{
    public CurrentAccount(Customer customer) {
        super(customer);
    }

    @Override
    public void printStatement() {
        Window window = new Window();

        window.showMessage(
                "======== Current Account Bank Statement ======== \n" +
                        super.printAccountStatement(),
                "Current Account Statement",
                JOptionPane.PLAIN_MESSAGE
        );
    }
}
