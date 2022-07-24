package digitalBank;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

public class Bank extends Window {
    private String name;
    private List<Account> accounts;

    public int welcome(){
        return confirmDialog(
                "Welcome to our Online Banking System!\n Would you like to create an account?",
                "Welcome!",
                JOptionPane.YES_NO_OPTION);
    }
    public void createAccount(Customer customer) {
        String name = inputDialog(
                "Please, enter your name:",
                "Name",
                JOptionPane.INFORMATION_MESSAGE
        );
        customer.setName(name);

        int age = Integer.parseInt(inputDialog(
                "Please, enter your age:",
                "Age",
                JOptionPane.INFORMATION_MESSAGE
        ));
        customer.setAge(age);


        String nationality = inputDialog(
                "Please, enter your nationality:",
                "Nationality",
                JOptionPane.INFORMATION_MESSAGE
        );
        customer.setNationality(nationality);
    }

    protected int accountOptions(String holderName) {
        return Integer.parseInt(inputDialog(
                "Welcome, " + holderName + "! \n What would you like to do? " +
                        "\n 1. Account Details " +
                        "\n 2. Deposit " +
                        "\n 3. Transfer " +
                        "\n 4. Withdraw" +
                        "\n 5. Exit",
                "Account",
                JOptionPane.QUESTION_MESSAGE));
    }

    protected void showAccountDetails(Account currentAcc, Account savingsAcc) {
        String currInfo = currentAcc.printAccountStatement();
        String savingsInfo = savingsAcc.printAccountStatement();

        showMessage(
                "======== Current Account Details ======== \n" +
                        currInfo +
                        "======== Savings Account Details ======== \n" +
                        savingsInfo,
                "Account Details",
                JOptionPane.PLAIN_MESSAGE
        );
    }

    protected void operations(String operation, Account current, Account savings){
        if (Objects.equals(operation, "deposit")) {
            int account = optionDialog(
                    "Which account would you like to make a deposit?",
                    "Choose an account",
                    JOptionPane.QUESTION_MESSAGE,
                    JOptionPane.YES_NO_OPTION,
                    "Current Account",
                    "Savings Account"
            );

            double amount = Double.parseDouble(inputDialog(
                    "Please, enter the deposit amount:",
                    "Deposit",
                    JOptionPane.PLAIN_MESSAGE
            ));

            if (account == 0)
                current.deposit(amount);
            if (account == 1)
                savings.deposit(amount);
        }

        if (Objects.equals(operation, "transfer")){
            int sender = optionDialog(
                    "Choose sender:",
                    "Choose an account",
                    JOptionPane.QUESTION_MESSAGE,
                    JOptionPane.YES_NO_OPTION,
                    "Current Account",
                    "Savings Account"
            );

            double amount = Double.parseDouble(inputDialog(
                    "Please, enter the amount to transfer:",
                    "Transfer",
                    JOptionPane.PLAIN_MESSAGE
            ));

            int targetAccount = optionDialog(
                    "Choose destination:",
                    "Destination",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    "Current Account",
                    "Savings Account");

            if (sender == 0 && targetAccount == 1) {
                current.transfer(amount, savings);
                current.printStatement();
            } else if (sender == 1 && targetAccount == 0) {
                savings.transfer(amount, current);
                savings.printStatement();
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Invalid account.");
            }
        }

        if (Objects.equals(operation, "withdraw")) {
            int withdrawAcc = optionDialog(
                    "Choose the account to withdraw funds:",
                    "Choose an account",
                    JOptionPane.QUESTION_MESSAGE,
                    JOptionPane.YES_NO_OPTION,
                    "Current Account",
                    "Savings Account"
            );

            double amount = Double.parseDouble(inputDialog(
                    "Please, enter the withdraw amount:",
                    "Withdraw",
                    JOptionPane.PLAIN_MESSAGE
            ));

            if (withdrawAcc == 0) {
                current.withdraw(amount);
                current.printStatement();
            } else {
                savings.withdraw(amount);
                savings.printStatement();
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
