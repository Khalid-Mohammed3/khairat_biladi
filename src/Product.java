
import java.util.ArrayList;
import java.util.Scanner;

public class Product {

    // Product attributes
    private int productId;
    private String productName;
    private double price;

    // List to store all products
    private static final ArrayList<Product> products = new ArrayList<>();

    // Constructor
    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    // Getter methods
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    // Add a new product
    public static void addProduct(Scanner scanner) {

        System.out.println("\n===== Add New Product =====");

        int id;

        while (true) {
            System.out.print("Enter Product ID: ");
            String input = scanner.nextLine();

            try {
                id = Integer.parseInt(input);

                if (id <= 0) {
                    System.out.println("Product ID must be positive.");
                    continue;
                }

                if (findProductById(id) != null) {
                    System.out.println("This Product ID already exists.");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer ID.");
            }
        }

        String name;

        while (true) {
            System.out.print("Enter Product Name: ");
            name = scanner.nextLine().trim();

            if (!name.isEmpty()) {
                break;
            }

            System.out.println("Product name cannot be empty.");
        }

        double productPrice;

        while (true) {
            System.out.print("Enter Product Price: ");
            String input = scanner.nextLine();

            try {
                productPrice = Double.parseDouble(input);

                if (!Double.isFinite(productPrice) || productPrice <= 0) {
                    System.out.println("Price must be a positive number.");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid price.");
            }
        }

        Product newProduct = new Product(id, name, productPrice);

        products.add(newProduct);

        System.out.println("\nProduct added successfully!");
    }

    // View all products
    public static void viewProducts() {

        System.out.println("\n===== Product List =====");

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product product : products) {

            System.out.println("------------------------");
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.printf("Price: %.2f%n", product.getPrice());
        }

        System.out.println("------------------------");
    }

    // Find a product by its ID
    public static Product findProductById(int productId) {

        for (Product product : products) {

            if (product.getProductId() == productId) {
                return product;
            }
        }

        return null;
    }
}
