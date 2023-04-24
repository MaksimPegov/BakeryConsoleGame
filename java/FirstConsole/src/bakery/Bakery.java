package bakery;

import products.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class Bakery implements BakeryInterface {
    private final String name;
    private double balance;

    private ArrayList<Product> products;

    public Bakery(String name, double balance) {
        this.name = name;
        this.balance = balance;

        products = new ArrayList<>();

        System.out.println("Bakery " + name + " has been created!");
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean isInStock(String name) {
        try {
            return getProduct(name).getAmount() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Product getProduct(String name) {
            boolean found = false;
            int index = -1;
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getName().equals(name)) {
                    found = true;
                    index = i;
                    break;
                }
            }

            if (found) {
                return products.get(index);
            }else {
                return null;
            }
    }

    public String addProduct(String name, double bakePrice, double sellPrice) {
        if (hasProduct(name)) {
            return "Recipe already exists, please choose another name!";
        }
        products.add(new Product(name, bakePrice, sellPrice));
        return "Recipe " + name + " has been added!";
    }

    public HashMap<String, Integer> getProducts() {
        HashMap<String, Integer> productsMap = new HashMap<>();
        for (Product product : products) {
            if (product.getAmount() == 0){
                continue;
            }
            productsMap.put(product.getName(), product.getAmount());
        }
        return productsMap;
    }

    @Override
    public ArrayList<Product> getRecipes() {
        return products;
    }


    @Override
    public String bakeProduct(String name, int amount) {
        try {
            Product productLocal = getProduct(name);
            if (productLocal.getMakePrice() * amount > balance) {
                return "Not enough money(";
            }
            for (int i = 0; i < amount; i++) {
                balance -= productLocal.getMakePrice();
                productLocal.increase();
            }
            return amount + " " + name + " has been baked!";

        } catch (Exception e) {
            return "No such product!";
        }
    }

    @Override
    public String sellProduct(String name, int amount) {
        if (amount <= 0) {
            return "Invalid amount!";
        }

        try {
            Product productLocal = getProduct(name);

            if (productLocal.getAmount() < amount) {
                return "Not enough products!";
            }
            for (int i = 0; i < amount; i++) {
                balance += productLocal.getSellPrice();
                productLocal.decrease();
            }
            return amount + " " + name + " has been sold!";
        } catch (Exception e) {
            return "No such product!";
        }
    }

    @Override
    public boolean hasProduct(String name) {
        return getProduct(name) != null;
    }

}
