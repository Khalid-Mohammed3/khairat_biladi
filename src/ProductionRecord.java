import java.time.LocalDate;
import java.util.Scanner;

public class ProductionRecord {

    private final  Product product;
    private final int quantity;
    private final String date;

    public ProductionRecord(Product product, int quantity, String date) {
        this.product = product;
        this.quantity = quantity;
        this.date = date;
    }

    public static void recordProduction(Scanner input) {

        if (AppData.products.isEmpty()) {
            System.out.println("No products available!");
            System.out.println("Ask your partner to add products first.");
            return;
        }

        System.out.println("\nAvailable Products:");

        for (int i = 0; i < AppData.products.size(); i++) {
            System.out.println((i + 1) + ". "
                    + AppData.products.get(i).getProductName());
        }

        System.out.print("Choose product number: ");

        int choice;

        try {
            choice = Integer.parseInt(input.nextLine());

            if (choice < 1 || choice > AppData.products.size()) {
                System.out.println("Invalid product number!");
                return;
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
            return;
        }

        System.out.print("Enter production quantity: ");

        int quantity;

        try {
            quantity = Integer.parseInt(input.nextLine());

            if (quantity <= 0) {
                System.out.println("Quantity must be greater than zero!");
                return;
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid quantity!");
            return;
        }

        Product selectedProduct = AppData.products.get(choice - 1);

        String date = LocalDate.now().toString();

        ProductionRecord record =
                new ProductionRecord(selectedProduct, quantity, date);

        AppData.productionRecords.add(record);

        System.out.println("Production recorded successfully!");
    }

    public static void viewProduction() {

        if (AppData.productionRecords.isEmpty()) {
            System.out.println("No production records found!");
            return;
        }

        int total = 0;

        System.out.println("\n===== PRODUCTION RECORDS =====");

        for (ProductionRecord record : AppData.productionRecords) {

            System.out.println("Product: "
                    + record.product.getProductName());

            System.out.println("Quantity: " + record.quantity);

            System.out.println("Date: " + record.date);

            System.out.println("------------------------");

            total += record.quantity;
        }

        System.out.println("Total Production: " + total);
    }
}