package digitalBank;

import javax.swing.*;

public abstract class Account implements IAccount {
    private static final int STANDARD_AGENCY = 1;
    private static int ACCOUNT_NUMBER_ACC = 1;
    protected int agency;
    protected int number;
    protected double balance;
    protected Customer customer;

    public Account(Customer customer) {
        this.agency = Account.STANDARD_AGENCY;
        this.number = ACCOUNT_NUMBER_ACC++;
        this.customer = customer;
    }

    @Override
    public void withdraw(double amount) {
        if (this.balance >= amount) {
        balance -= amount;
        } else {
            JOptionPane.showMessageDialog(null,"Insufficient funds.");
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        this.printStatement();
    }

    @Override
    public void transfer(double amount, IAccount targetAccount) {
            if (this.balance >= amount) {
                this.withdraw(amount);
                targetAccount.deposit(amount);
            } else {
                JOptionPane.showMessageDialog(null,"Insufficient funds.");
            }
    }

    protected String printAccountStatement() {
        return String.format("Holder: %s%n", this.customer.getName()) +
                String.format("Agency: %d%n", this.agency) +
                String.format("Number: %d%n", this.number) +
                String.format("Balance: R$ %.2f%n", this.balance);
    }

    public int getAgency() {
        return agency;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }
}
