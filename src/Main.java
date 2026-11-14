import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== Khairat Biladi Management System =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product");
            System.out.println("4. Record Production");
            System.out.println("5. View Production");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        Product.addProduct(scanner);
                        break;

                    case 2:
                        Product.viewProducts();
                        break;

                    case 3:
                        System.out.print("Enter Product ID: ");

                        try {
                            int id = Integer.parseInt(scanner.nextLine());

                            Product product = Product.findProductById(id);

                            if (product != null) {
                                System.out.println("Product Found!");
                                System.out.println("ID: " + product.getProductId());
                                System.out.println("Name: " + product.getProductName());
                                System.out.println("Size: " + product.getSizeMl() + " ml");
                                System.out.println("Price: " + product.getPrice());
                            } else {
                                System.out.println("Product not found.");
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Invalid Product ID.");
                        }
                        break;

                    case 4:
                        ProductionRecord.recordProduction(scanner);
                        break;

                    case 5:
                        ProductionRecord.viewProduction();
                        break;

                    case 0:
                        System.out.println("Thank you for using Khairat Biladi!");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid menu number.");
                choice = -1;
            }

        } while (choice != 0);

        scanner.close();
    }
}