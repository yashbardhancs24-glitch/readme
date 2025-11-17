package Collections;
import java.util.*;

class Order {
    int orderId;
    String customerName;
    double amount;

    Order(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
    }

    
   
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        return orderId == order.orderId;
    }

   
    public int hashCode() {
        return Objects.hash(orderId);
    }

   
    public String toString() {
        return "Order{" + "id=" + orderId + ", customer='" + customerName + "', amount=" + amount + "}";
    }
}

public class Ecommerse_order_processing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Order> orders = new ArrayList<>();
        Set<Order> uniqueOrders = new HashSet<>();
        Queue<Order> processingQueue = new LinkedList<>();
        Stack<Order> failedOrders = new Stack<>();

        
        System.out.print("How many orders to add? ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.println("Enter orderId, customerName, amount:");
            int id = scanner.nextInt();
            scanner.nextLine(); 
            String name = scanner.nextLine();
            double amount = scanner.nextDouble();
            scanner.nextLine(); 

            orders.add(new Order(id, name, amount));
        }

       
        uniqueOrders.addAll(orders);

        
        processingQueue.addAll(uniqueOrders);

        while (!processingQueue.isEmpty()) {
            Order current = processingQueue.poll(); // FIFO order
            System.out.println("Processing: " + current);

            
            if (current.amount < 100) {
                System.out.println("Order failed, will retry: " + current);
                failedOrders.push(current);
            }
        }

        
        while (!failedOrders.isEmpty()) {
            Order retryOrder = failedOrders.pop();
            System.out.println("Retrying failed order: " + retryOrder);
            
        }
    }
}

