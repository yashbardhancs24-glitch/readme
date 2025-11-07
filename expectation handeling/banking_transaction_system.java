package Exception;
import java.util.Random;

//Custom exception for negative amount
class NegativeAmountException extends Exception {
 public NegativeAmountException(String message) {
     super(message);
 }
}

//Custom exception for insufficient funds
class InsufficientFundsException extends Exception {
 public InsufficientFundsException(String message) {
     super(message);
 }
}

//Custom exception for network failure
class NetworkFailureException extends Exception {
 public NetworkFailureException(String message) {
     super(message);
 }
}

//Transaction class
class Transaction {
 private Random random = new Random();

 public void performTransaction() throws NegativeAmountException, InsufficientFundsException, NetworkFailureException {
     int result = random.nextInt(4); // 0 to 3

     switch (result) {
         case 0:
             throw new NegativeAmountException("Transaction failed: Negative amount entered.");
         case 1:
             throw new InsufficientFundsException("Transaction failed: Insufficient balance.");
         case 2:
             throw new NetworkFailureException("Transaction failed: Network issues encountered.");
         default:
             System.out.println("Transaction completed successfully.");
     }
 }
}

//Main class
public class banking_transaction_system  {
 public static void main(String[] args) {
     Transaction transaction = new Transaction();

     try {
         transaction.performTransaction();
     } catch (NegativeAmountException e) {
         System.out.println(e.getMessage());
     } catch (InsufficientFundsException e) {
         System.out.println(e.getMessage());
     } catch (NetworkFailureException e) {
         System.out.println(e.getMessage());
     }
 }
}

