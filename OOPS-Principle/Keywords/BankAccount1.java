package Keywords;

public class BankAccount1 {
    private static String bankName = "State bank of India";
    private static int totalAccounts = 0;
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount1(String lyndaPrincy, String acc12345, int i) {
    }

    public void BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }

    public BankAccount1(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public static void getTotalAccounts() {
        System.out.println("Total number of accounts: " + totalAccounts);
    }

    public void displayAccountDetails() {
        if (this instanceof BankAccount1) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
        }
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    public static void main(String[] args) {
        BankAccount1 b1 = new BankAccount1("Lynda Princy","ACC12345",1000);
        BankAccount1 b2 = new BankAccount1("Prince Danish","ACC67890",500);
        b1.displayAccountDetails();
        b2.displayAccountDetails();
        BankAccount1.getTotalAccounts();
    }
}
