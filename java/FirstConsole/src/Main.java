import bakery.Bakery;
import products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, start your new bakery business with us!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter bakery name:");
        String name = scanner.nextLine();
        System.out.println("Please enter start balance (if you using float numbers write them with dot e.g. 3.14):");
        double balance = scanner.nextDouble();
        scanner.nextLine();
        Bakery bakery = new Bakery(name, balance);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Balance: " + bakery.getBalance());
            System.out.println("What would you like to do?");
            System.out.println("1. Bake a product");
            System.out.println("2. Sell a product");
            System.out.println("3. List available products");
            System.out.println("4. List all recipes");
            System.out.println("5. Add a recipe");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("Please enter product name:");
                    String productNameTemp = scanner.nextLine();

                    if (!bakery.hasProduct(productNameTemp)) {
                        System.out.println("No such product! You need to add recipe first!");
                        break;
                    }
                    System.out.println("Please enter quantity:");
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(bakery.bakeProduct(productNameTemp, amount));
                }

                case 2 -> {
                    System.out.println("Please enter product name:");
                    String productNameTemp = scanner.nextLine();
                    if (!bakery.isInStock(productNameTemp)) {
                        System.out.println("No such product! You need to bake it at first!");
                        break;
                    }
                    System.out.println("Please enter quantity:");
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(bakery.sellProduct(productNameTemp, amount));
                }

                case 5 -> {
                    System.out.println("Please enter product name:");
                    String productNameTemp = scanner.nextLine();
                    if (bakery.hasProduct(productNameTemp)) {
                        System.out.println("Recipe already exists, please choose another name!");
                        break;
                    }
                    System.out.println("Please enter expenses for this product:");
                    double productExpensesTemp = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Please enter selling price of the product:");
                    double productPriceTemp = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println(bakery.addProduct(productNameTemp, productExpensesTemp, productPriceTemp));
                }

                case 3 -> {
                    HashMap<String,Integer> products = bakery.getProducts();
                    if (products.size() == 0) {
                        System.out.println("No products yet!");
                    }
                    for (String product : products.keySet()) {
                        System.out.println(
                                product +
                                ", quantity: " +
                                products.get(product) +
                                " sell price: " +
                                bakery.getProduct(product).getSellPrice()
                        );
                    }
                }

                case 4 -> {
                    ArrayList<Product> recipes = bakery.getRecipes();
                    if (recipes.size() == 0) {
                        System.out.println("No recipes yet!");
                    } else {
                        for (Product recipe : recipes) {
                            System.out.println(
                                    recipe.getName() +
                                            ", make price:" +
                                            recipe.getMakePrice() +
                                            ", sells for:" +
                                            recipe.getSellPrice() +
                                            ", quantity:" +
                                            recipe.getAmount()
                            );
                        }
                    }
                }

                case 6 -> isRunning = false;

                default -> System.out.println("Invalid choice!");
            }
        }

        
    }
}