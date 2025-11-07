package Exception;
import java.util.*;
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// ATM class with balance and withdraw method
class ATM {
    private int balance = 10000; // initial balance ₹10,000

    public void withdraw(int amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Available balance: ₹" + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: ₹" + balance);
    }
}

// Main class to test ATM withdrawal
public class ATM_Exception {
    public static void main(String[] args) {
        ATM atm = new ATM();
        int amountToWithdraw = 15000; // example amount

        try {
            atm.withdraw(amountToWithdraw);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

