package digitalBank;

public abstract class Account implements IAccount{
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
        balance -= amount;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void transfer(double amount, IAccount targetAccount) {
        this.withdraw(amount);
        targetAccount.deposit(amount);
    }

    protected void printAccountStatement() {
        System.out.printf("Customer: %s%n", this.customer.getName());
        System.out.printf("Agency: %d%n", this.agency);
        System.out.printf("Number: %d%n", this.number);
        System.out.printf("Balance: R$ %.2f%n", this.balance);
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
