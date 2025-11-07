package Exception;
import java.util.Random;

//Custom exception for out of stock
class OutOfStockException extends Exception {
 public OutOfStockException(String message) {
     super(message);
 }
}

//Custom exception for payment failure
class PaymentFailedException extends Exception {
 public PaymentFailedException(String message) {
     super(message);
 }
}

//Order processing class
class OrderProcessor {
 private Random random = new Random();

 // Method to place order with random failures
 public void placeOrder() throws OutOfStockException, PaymentFailedException {
     int result = random.nextInt(3); // 0, 1 or 2

     if (result == 0) {
         throw new OutOfStockException("Product is out of stock.");
     } else if (result == 1) {
         throw new PaymentFailedException("Payment failed. Please try again.");
     } else {
         System.out.println("Order placed successfully!");
     }
 }
}

//Main class to test order processing
public class online_order_processor {
 public static void main(String[] args) {
     OrderProcessor orderProcessor = new OrderProcessor();

     try {
         orderProcessor.placeOrder();
     } catch (OutOfStockException | PaymentFailedException e) {
         System.out.println("Error: " + e.getMessage());
     }
 }
}



