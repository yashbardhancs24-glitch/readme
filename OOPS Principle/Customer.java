import java.util.ArrayList;
import java.util.List;

class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }
    public void viewBalance(String bankName) {
        for (Account acc : accounts) {
            if (acc.getBankName().equals(bankName)) {
                System.out.println(this.name + "'s balance at " + bankName + ": $" + acc.getBalance());
                return;
            }
        }
        System.out.println(this.name + " does not have an account at " + bankName);
    }
}

class Account {
    private double balance;
    private String bankName;

    public Account(String bankName, double initialBalance) {
        this.bankName = bankName;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getBankName() {
        return this.bankName;
    }
}

class Bank {
    private String name;

    public Bank(String name) {
        this.name = name;
    }
    public void openAccount(Customer customer, double initialDeposit) {
        System.out.println("Opening an account for " + customer.getName() + " at " + this.name);
        Account newAccount = new Account(this.name, initialDeposit);
        customer.addAccount(newAccount);
    }
}

public class BankDemo {
    public static void main(String[] args) {
        Bank myBank = new Bank("Global Trust Bank");
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");
        myBank.openAccount(customer1, 500.00);
        myBank.openAccount(customer2, 1200.00);
        customer1.viewBalance("Global Trust Bank");
        customer2.viewBalance("Global Trust Bank");
    }
}
