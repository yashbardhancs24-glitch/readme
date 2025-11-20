package map_interface;

import java.util.*;

public class InventoryManager {
    public static void main(String[] args) {

        // Map to store product -> quantity
        Map<String, Integer> inventory = new HashMap<>();

        // 1. Add new products
        inventory.put("Apples", 50);
        inventory.put("Bananas", 30);
        inventory.put("Milk", 10);
        inventory.put("Eggs", 0);
        sellProduct(inventory, "Apples", 20);
        sellProduct(inventory, "Milk", 15);
        sellProduct(inventory, "Oranges", 5);

        restockProduct(inventory, "Bananas", 40);
        restockProduct(inventory, "Eggs", 20);
        restockProduct(inventory, "Bread", 25);

        queryProduct(inventory, "Bananas");
        queryProduct(inventory, "Milk");
        queryProduct(inventory, "Chocolate");

        printOutOfStock(inventory);
    }

    public static void sellProduct(Map<String, Integer> inventory, String product, int qty) {
        if (!inventory.containsKey(product)) {
            System.out.println(product + " is not stocked.");
            return;
        }

        int newQty = inventory.get(product) - qty;

        if (newQty <= 0) {
            inventory.put(product, 0);
            System.out.println(product + " is now OUT OF STOCK.");
        } else {
            inventory.put(product, newQty);
            System.out.println(product + " updated quantity: " + newQty);
        }
    }

    public static void restockProduct(Map<String, Integer> inventory, String product, int qty) {
        inventory.put(product, inventory.getOrDefault(product, 0) + qty);
        System.out.println(product + " restocked. New quantity: " + inventory.get(product));
    }

    public static void queryProduct(Map<String, Integer> inventory, String product) {
        if (!inventory.containsKey(product)) {
            System.out.println(product + " is not stocked.");
        } else {
            System.out.println(product + " → " + inventory.get(product) + " units available.");
        }
    }

    public static void printOutOfStock(Map<String, Integer> inventory) {
        System.out.println("\nProducts OUT OF STOCK:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            if (entry.getValue() == 0) {
                System.out.println("- " + entry.getKey());
            }
        }
    }
}
