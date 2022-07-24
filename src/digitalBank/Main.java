package digitalBank;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Account currentAcc = new CurrentAccount(customer);
        Account savingsAcc = new SavingsAccount(customer);
        Bank bank = new Bank();
        boolean active = true;

            int createAcc = bank.welcome();

            if (createAcc == JOptionPane.YES_OPTION){

                bank.createAccount(customer);

                do {
                    int choice = bank.accountOptions(customer.getName());

                    switch (choice) {
                        case 1:
                            bank.showAccountDetails(currentAcc, savingsAcc);
                            break;
                        case 2:
                            bank.operations("deposit", currentAcc, savingsAcc);
                            break;
                        case 3:
                            bank.operations("transfer", currentAcc, savingsAcc);
                            break;
                        case 4:
                            bank.operations("withdraw", currentAcc, savingsAcc);
                            break;
                        case 5:
                            active = false;
                            break;
                        default:
                            bank.accountOptions(customer.getName());
                            break;
                    }
                } while (active);

            }
        }
}
