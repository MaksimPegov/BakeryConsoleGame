package bakery;

import products.Product;

import java.util.ArrayList;
import java.util.HashMap;

public interface BakeryInterface {
    String addProduct(String name, double bakePrice, double sellPrice);

    HashMap<String,Integer> getProducts();

    ArrayList<Product> getRecipes();

    String bakeProduct(String name, int amount);

    String sellProduct(String name, int amount);

    boolean hasProduct(String name);

    double getBalance();

    boolean isInStock(String name);

    Product getProduct(String name);
}
