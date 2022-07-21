package digitalBank;

public class CurrentAccount extends Account{
    public CurrentAccount(Customer customer) {
        super(customer);
    }

    @Override
    public void printStatement() {
        System.out.println("=== Current Account Bank Statement ===");
        super.printAccountStatement();
    }
}
