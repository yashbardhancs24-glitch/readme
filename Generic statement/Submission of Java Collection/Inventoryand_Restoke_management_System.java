package Collections;
import java.util.*;

//Product class
class Product {
 String name;
 double price;
 int stock;

 public Product(String name, double price, int stock) {
     this.name = name;
     this.price = price;
     this.stock = stock;
 }

 @Override
 public String toString() {
     return name + " (₹" + price + ", stock: " + stock + ")";
 }
}

//InventoryManagement class
public class Inventoryand_Restoke_management_System {
 private Set<String> productNames = new HashSet<>();
 private List<Product> products = new ArrayList<>();
 private Queue<Product> restockQueue = new LinkedList<>();
 private Stack<Product> restockedStack = new Stack<>();

 // Add a new product (avoid duplicates)
 public void addProduct(String name, double price, int stock) {
     if (productNames.add(name)) {
         Product product = new Product(name, price, stock);
         products.add(product);
         System.out.println("Product added: " + product);
     } else {
         System.out.println("Product " + name + " already exists.");
     }
 }

 // Check low stock and enqueue for restocking
 public void checkRestock(int threshold) {
     for (Product p : products) {
         if (p.stock < threshold && !restockQueue.contains(p)) {
             restockQueue.add(p);
             System.out.println("Added to restock queue: " + p);
         }
     }
 }

 // Process restock queue
 public void processRestock(int restockAmount) {
     if (restockQueue.isEmpty()) {
         System.out.println("No products to restock.");
         return;
     }
     Product product = restockQueue.poll();
     product.stock += restockAmount;
     restockedStack.push(product);
     System.out.println("Restocked: " + product);
 }

 // Undo last restock (rollback)
 public void undoRestock() {
     if (restockedStack.isEmpty()) {
         System.out.println("No restocks to undo.");
         return;
     }
     Product product = restockedStack.pop();
     product.stock -= 10; // Undo by subtracting the restock amount (assuming 10)
     System.out.println("Undo restock: " + product);
 }

 // Display all products
 public void displayProducts() {
     System.out.println("All Products:");
     for (Product p : products) {
         System.out.println(p);
     }
 }

 // Example usage
 public static void main(String[] args) {
	 Inventoryand_Restoke_management_System inventory = new Inventoryand_Restoke_management_System();
     inventory.addProduct("Milk", 50.0, 5);
     inventory.addProduct("Bread", 30.0, 2);
     inventory.addProduct("Milk", 50.0, 5); // Duplicate

     inventory.checkRestock(10); // Products with stock < 10 go to restock queue

     inventory.processRestock(10); // Restock first item in queue
     inventory.processRestock(10); // Restock next item

     inventory.undoRestock(); // Undo last restock

     inventory.displayProducts();
 }
}


