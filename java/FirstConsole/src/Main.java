import bakery.Bakery;
import products.Product;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, start your new bakery business with us!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter bakery name:");
        String name = scanner.nextLine();
        System.out.println("Please enter start balance:");
        int balance = scanner.nextInt();
        Bakery bakery = new Bakery(name, balance);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Balance: " + bakery.getBalance());
            System.out.println("What would you like to do?");
            System.out.println("1. Bake a product");
            System.out.println("2. Sell a product");
            System.out.println("3. List all products");
            System.out.println("4. Add a recipe");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("Please enter product name:");
                    String productNameTemp = scanner.nextLine();
                    System.out.println("Please enter amount:");
                    int amount = scanner.nextInt();
                    System.out.println(bakery.bakeProduct(productNameTemp, amount));
                }
                case 2 -> {
                    System.out.println("Please enter product name:");
                    String productNameTemp = scanner.nextLine();
                    System.out.println("Please enter amount:");
                    int amount = scanner.nextInt();
                    System.out.println(bakery.sellProduct(productNameTemp, amount));
                }
                case 4 -> {
                    System.out.println("Please enter product name:");
                    String productNameTemp = scanner.nextLine();
                    System.out.println("Please enter expenses for this product:");
                    int productExpensesTemp = scanner.nextInt();
                    System.out.println("Please enter selling price of the product:");
                    int productPriceTemp = scanner.nextInt();
                    System.out.println(bakery.addProduct(productNameTemp, productExpensesTemp, productPriceTemp));
                }
                case 3 -> {
                    ArrayList<Product> products = bakery.listProducts();
                    if (products.size() == 0) {
                        System.out.println("No products yet!");
                    }
                    for (Product product : products) {
                        System.out.println(
                                product.getName() +
                                        ", make price:" +
                                        product.getMakePrice() +
                                        ", sells for:" +
                                        product.getSellPrice() +
                                        ", amount:" +
                                        product.getAmount()
                        );
                    }
                }
                case 5 -> isRunning = false;
                default -> System.out.println("Invalid choice!");
            }
        }

        
    }
}