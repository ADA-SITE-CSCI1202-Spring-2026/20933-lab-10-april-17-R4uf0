import java.util.*;
import java.util.function.Predicate;

class Product {
    private String name;
    private double price;
    private boolean inStock;

    public Product(String name, double price, boolean inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isInStock() { return inStock; }

    @Override
    public String toString() {
        return name + " ($" + price + ", " + (inStock ? "In Stock" : "Out of Stock") + ")";
    }
}

public class FilteringDemo {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>(List.of(
                new Product("Notebook", 12.99, true),
                new Product("Headphones", 89.99, true),
                new Product("USB Cable", 8.49, true),
                new Product("Monitor", 299.00, false),
                new Product("Mouse Pad", 19.99, true),
                new Product("Webcam", 55.00, true),
                new Product("Sticky Notes", 4.99, false),
                new Product("Keyboard", 45.00, true)
        ));

        Predicate<Product> isAffordable =
                p -> p.getPrice() < 50 && p.isInStock();

        products.removeIf(isAffordable.negate());

        System.out.println("Affordable & In-Stock Products:");
        products.forEach(System.out::println);
    }
}