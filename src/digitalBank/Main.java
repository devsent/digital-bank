package digitalBank;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("Jon Doe");

        Account currentAcc = new CurrentAccount(customer);
        Account savingsAcc = new SavingsAccount(customer);

        currentAcc.deposit(1000);
        currentAcc.transfer(400, savingsAcc);

        currentAcc.printStatement();
        savingsAcc.printStatement();
    }
}
