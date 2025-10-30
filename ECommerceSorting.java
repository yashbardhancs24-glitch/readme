package Lambda_function;

import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    public Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return name + " | ₹" + price + " | ⭐" + rating + " | " + discount + "% off";
    }
}

public class ECommerceSorting {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Phone", 25000, 4.5, 10));
        products.add(new Product("Laptop", 55000, 4.7, 15));
        products.add(new Product("Headphones", 2000, 4.2, 30));
        products.add(new Product("Smartwatch", 8000, 4.1, 25));

        System.out.println("🛍️ Original Product List:");
        products.forEach(System.out::println);

        // 🔹 Sort by Price (Low to High)
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        System.out.println("\n💰 Sorted by Price (Low → High):");
        products.forEach(System.out::println);

        // 🔹 Sort by Rating (High to Low)
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        System.out.println("\n⭐ Sorted by Rating (High → Low):");
        products.forEach(System.out::println);

        // 🔹 Sort by Discount (High to Low)
        products.sort((p1, p2) -> Double.compare(p2.discount, p1.discount));
        System.out.println("\n🎁 Sorted by Discount (High → Low):");
        products.forEach(System.out::println);
    }
}
