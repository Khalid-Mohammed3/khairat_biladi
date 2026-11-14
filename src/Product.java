import java.util.Scanner;

public class Product {

    // Product attributes
    private final int productId;
    private final String productName;
    private final int sizeMl;
    private final double price;

    // Constructor
    public Product(int productId, String productName,
                   int sizeMl, double price) {

        this.productId = productId;
        this.productName = productName;
        this.sizeMl = sizeMl;
        this.price = price;
    }

    // Getter methods
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getSizeMl() {
        return sizeMl;
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

            try {
                id = Integer.parseInt(scanner.nextLine());

                if (id <= 0) {
                    System.out.println("ID must be positive.");
                    continue;
                }

                if (findProductById(id) != null) {
                    System.out.println("Product ID already exists.");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("Enter a valid ID.");
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

        int size;

        while (true) {
            System.out.print("Enter Product Size (ml): ");

            try {
                size = Integer.parseInt(scanner.nextLine());

                if (size <= 0) {
                    System.out.println("Size must be positive.");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("Enter a valid size.");
            }
        }

        double productPrice;

        while (true) {
            System.out.print("Enter Product Price: ");

            try {
                productPrice = Double.parseDouble(scanner.nextLine());

                if (!Double.isFinite(productPrice)
                        || productPrice <= 0) {

                    System.out.println("Price must be positive.");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("Enter a valid price.");
            }
        }

        Product newProduct =
                new Product(id, name, size, productPrice);

        AppData.products.add(newProduct);

        System.out.println("\nProduct added successfully!");
    }

    // View all products
    public static void viewProducts() {

        System.out.println("\n===== Product List =====");

        if (AppData.products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product product : AppData.products) {

            System.out.println("------------------------");

            System.out.println("Product ID: "
                    + product.getProductId());

            System.out.println("Product Name: "
                    + product.getProductName());

            System.out.println("Size: "
                    + product.getSizeMl() + " ml");

            System.out.printf("Price: %.2f%n",
                    product.getPrice());
        }

        System.out.println("------------------------");
    }

    // Find product by ID
    public static Product findProductById(int productId) {

        for (Product product : AppData.products) {

            if (product.getProductId() == productId) {
                return product;
            }
        }

        return null;
    }
}