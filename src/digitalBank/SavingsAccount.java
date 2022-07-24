package digitalBank;

import javax.swing.*;

public class SavingsAccount extends Account {
    public SavingsAccount(Customer customer) {
        super(customer);
    }

    @Override
    public void printStatement() {
        Window window = new Window();

        window.showMessage(
                "======== Savings Account Bank Statement ======== \n" +
                super.printAccountStatement(),
                "Savings Account Statement",
                JOptionPane.PLAIN_MESSAGE
        );
    }
}
